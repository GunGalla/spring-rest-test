package com.gungalla.springresttask.config;

import com.gungalla.springresttask.repository.TaskRepository;
import com.gungalla.springresttask.repository.UserRepository;
import com.gungalla.springresttask.service.AuthService;
import com.gungalla.springresttask.service.ImageService;
import com.gungalla.springresttask.service.TaskService;
import com.gungalla.springresttask.service.UserService;
import com.gungalla.springresttask.service.impl.AuthServiceImpl;
import com.gungalla.springresttask.service.impl.ImageServiceImpl;
import com.gungalla.springresttask.service.impl.TaskServiceImpl;
import com.gungalla.springresttask.service.impl.UserServiceImpl;
import com.gungalla.springresttask.service.props.JwtProperties;
import com.gungalla.springresttask.service.props.MinioProperties;
import com.gungalla.springresttask.web.security.JwtTokenProvider;
import com.gungalla.springresttask.web.security.JwtUserDetailsService;
import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@TestConfiguration
@RequiredArgsConstructor
public class TestConfig {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final AuthenticationManager authenticationManager;

    @Bean
    @Primary
    public BCryptPasswordEncoder testPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtProperties jwtProperties() {
        JwtProperties jwtProperties = new JwtProperties();
        jwtProperties.setSecret("ZmZydGJ5dGRicnRzZ3Jlc2FmcnNmc2FmZWE=");
        return jwtProperties;
    }

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        return new JwtUserDetailsService(userService());
    }

    @Bean
    public MinioClient minioClient() {
        return Mockito.mock(MinioClient.class);
    }

    @Bean
    public MinioProperties minioProperties() {
        MinioProperties properties = new MinioProperties();
        properties.setBucket("images");
        return properties;
    }

    @Bean
    @Primary
    public ImageService imageService() {
        return new ImageServiceImpl(minioClient(), minioProperties());
    }

    @Bean
    public JwtTokenProvider tokenProvider() {
        return new JwtTokenProvider(jwtProperties(),
                userDetailsService(),
                userService());
    }

    @Bean
    @Primary
    public UserService userService() {
        return new UserServiceImpl(userRepository, testPasswordEncoder());
    }

    @Bean
    @Primary
    public TaskService taskService() {
        return new TaskServiceImpl(taskRepository, imageService());
    }

    @Bean
    @Primary
    public AuthService authService() {
        return new AuthServiceImpl(authenticationManager,
                userService(),
                tokenProvider());
    }

}
