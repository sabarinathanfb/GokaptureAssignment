package org.gokapture.blogapi.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTaskRequestDto {

    private int tasks;
    private int offset;
    private String title;
}
