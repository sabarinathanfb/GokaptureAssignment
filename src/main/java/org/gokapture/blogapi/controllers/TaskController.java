package org.gokapture.blogapi.controllers;

import org.gokapture.blogapi.Mapper.TaskMapper;
import org.gokapture.blogapi.dtos.TaskRequestDto;
import org.gokapture.blogapi.dtos.TaskResponseDto;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.models.User;
import org.gokapture.blogapi.models.enums.TaskStatus;
import org.gokapture.blogapi.repositories.TaskRepository;
import org.gokapture.blogapi.repositories.UserRepository;
import org.gokapture.blogapi.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {


    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final UserRepository userRepository;

    public TaskController(TaskService taskService,TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
        this.userRepository = userRepository;
    }




    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setPriority(request.getPriority());
        task.setStatus(request.getStatus());
        task.setDueDate(request.getDueDate());
        task.setUser(user);


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


    // Search tasks
    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String searchTerm) {
        return taskService.searchTasks(searchTerm);
    }


    // API endpoint to filter tasks by status
    @GetMapping("/filter/status")
    public List<Task> filterByStatus(@RequestParam String status) {
        // Convert the status string to TaskStatus enum
        TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase());
        return taskService.filterByStatus(taskStatus);
    }

    // Filter tasks by priority
    @GetMapping("/filter/priority")
    public List<Task> filterByPriority(@RequestParam String priority) {
        return taskService.filterByPriority(priority);
    }

    // Filter tasks by due date
    @GetMapping("/filter/dueDate")
    public List<Task> filterByDueDate(@RequestParam LocalDate dueDate) {
        return taskService.filterByDueDate(dueDate);
    }











}
