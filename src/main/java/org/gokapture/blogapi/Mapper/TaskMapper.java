package org.gokapture.blogapi.Mapper;

import org.gokapture.blogapi.dtos.TaskResponseDto;
import org.gokapture.blogapi.models.Task;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {

    public static TaskResponseDto toDto(Task task) {

        TaskResponseDto dto = new TaskResponseDto();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setCreationTime(task.getCreatedAt());
        dto.setUpdateTime(task.getUpdatedAt());
        dto.setDueTime(task.getDueDate());

        return dto;


    }

    public static List<TaskResponseDto> toDtoList(List<Task> tasks) {

        if(tasks == null) return null;

        return tasks.stream().map(TaskMapper::toDto)
                .collect(Collectors.toList());


    }

}
