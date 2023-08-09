package com.gungalla.springresttask.web.mappers;

import com.gungalla.springresttask.domain.user.User;
import com.gungalla.springresttask.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto dto);

}
