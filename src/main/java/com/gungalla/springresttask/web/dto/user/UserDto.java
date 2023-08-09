package com.gungalla.springresttask.web.dto.user;

import com.gungalla.springresttask.domain.task.Task;
import com.gungalla.springresttask.domain.user.Role;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String passwordConfirmation;

}
