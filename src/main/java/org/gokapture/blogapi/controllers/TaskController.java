package org.gokapture.blogapi.controllers;

import org.gokapture.blogapi.Mapper.TaskMapper;
import org.gokapture.blogapi.dtos.TaskRequestDto;
import org.gokapture.blogapi.dtos.TaskResponseDto;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.repositories.TaskRepository;
import org.gokapture.blogapi.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto request) {

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

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> updateTask(@RequestBody TaskRequestDto request, @PathVariable("taskId") Long taskId) {
        // Pass the ID along with the updated details
        Task updatedTaskDetails = new Task();
        updatedTaskDetails.setTitle(request.getTitle());
        updatedTaskDetails.setDescription(request.getDescription());
        updatedTaskDetails.setPriority(request.getPriority());
        updatedTaskDetails.setStatus(request.getStatus());
        updatedTaskDetails.setDueDate(request.getDueDate());

        // Update the task and return the response
        Task updatedTask = taskService.updateTask(taskId, updatedTaskDetails);
        return new ResponseEntity<>(TaskMapper.toDto(updatedTask), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long taskId) {
        // Call the service method to delete the task
        taskService.deleteTask(taskId);
        // Return a 204 No Content status to indicate successful deletion
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }








}
