package org.gokapture.blogapi.controllers;

import org.gokapture.blogapi.Mapper.Mapper;
import org.gokapture.blogapi.Mapper.TaskMapper;
import org.gokapture.blogapi.dtos.TaskDto;
import org.gokapture.blogapi.dtos.TaskResponseDto;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.repositories.TaskRepository;
import org.gokapture.blogapi.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {


    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public TaskController(TaskService taskService,TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }




    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskDto request) {

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setDueDate(request.getDueDate());


        return new ResponseEntity<>(TaskMapper.toDto(taskService.createTask(task)), HttpStatus.CREATED);


    }

    @GetMapping("")
    public ResponseEntity<List<TaskResponseDto>> getAllTask(){

        List<Task> tasks = taskRepository.findAll();

        return new ResponseEntity<>(TaskMapper.toDtoList(tasks),HttpStatus.OK);

    }








}
