package com.gungalla.springresttask.repository;

import com.gungalla.springresttask.domain.user.Role;
import com.gungalla.springresttask.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean isTaskOwner(@Param("userId") Long userId, @Param("taskId") Long taskId);

}
