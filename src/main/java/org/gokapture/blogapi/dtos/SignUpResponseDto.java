package org.gokapture.blogapi.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpResponseDto {

    private String username;
    private String password;
}
