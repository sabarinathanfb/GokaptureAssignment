package org.gokapture.blogapi.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {

    private String username;
    private String password;
}
