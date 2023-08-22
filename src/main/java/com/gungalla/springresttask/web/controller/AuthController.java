package com.gungalla.springresttask.web.controller;

import com.gungalla.springresttask.domain.user.User;
import com.gungalla.springresttask.service.AuthService;
import com.gungalla.springresttask.service.UserService;
import com.gungalla.springresttask.web.dto.auth.JwtRequest;
import com.gungalla.springresttask.web.dto.auth.JwtResponse;
import com.gungalla.springresttask.web.dto.user.UserDto;
import com.gungalla.springresttask.web.dto.validation.OnCreate;
import com.gungalla.springresttask.web.mappers.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth Controller", description = "Auth API")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping("/login")
    @Operation(summary = "Log in")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    @Operation(summary = "Register new user")
    public UserDto register(@Validated(OnCreate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    @Operation(summary = "Refresh JWT token")
    public JwtResponse refresh(@RequestBody String refreshToken) {
        return authService.refresh(refreshToken);
    }

}
