package org.gokapture.blogapi.dtos;


import lombok.Getter;
import lombok.Setter;
import org.gokapture.blogapi.models.BaseModel;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.models.enums.TaskStatus;

import java.time.LocalDateTime;


@Getter
@Setter
public class TaskRequestDto {

    private String title;
    private String description;
    private TaskStatus status;
    private Task.Priority priority;
    private LocalDateTime dueDate;
    private Long userId;



}
