package org.gokapture.blogapi.dtos;

import lombok.Getter;
import lombok.Setter;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.models.enums.TaskStatus;

import java.time.LocalDateTime;



@Getter
@Setter
public class TaskResponseDto {

    private long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Task.Priority priority;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private LocalDateTime dueTime;

}
