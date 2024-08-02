package org.gokapture.blogapi.Mapper;

import org.gokapture.blogapi.dtos.UserDto;
import org.gokapture.blogapi.models.User;

public class Mapper {

    public static UserDto toDto(User user) {

        UserDto dto = new UserDto();

        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());

        return dto;
    }
}
