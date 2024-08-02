package org.gokapture.blogapi.dtos;

import lombok.Getter;
import lombok.Setter;
import org.gokapture.blogapi.models.Task;

import java.time.LocalDateTime;



@Getter
@Setter
public class TaskResponseDto {

    private long id;
    private String title;
    private String description;
    private Task.Status status;
    private Task.Priority priority;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private LocalDateTime dueTime;

}
