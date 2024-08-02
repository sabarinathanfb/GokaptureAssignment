package org.gokapture.blogapi.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.models.enums.TaskStatus;
import org.gokapture.blogapi.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task createTask(Task task ) {

        taskRepository.save(task);
        return taskRepository.findByTitle(task.getTitle());

    }

    public Task updateTask(Long taskId, Task updatedTaskDetails) {
        // Fetch the existing task
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id " + taskId));

        // Update the fields of the existing task
        existingTask.setTitle(updatedTaskDetails.getTitle());
        existingTask.setDescription(updatedTaskDetails.getDescription());
        existingTask.setStatus(updatedTaskDetails.getStatus());
        existingTask.setPriority(updatedTaskDetails.getPriority());
        existingTask.setDueDate(updatedTaskDetails.getDueDate());

        // Save and return the updated task
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long taskId) {
        // Check if the task exists
        if (!taskRepository.existsById(taskId)) {
            throw new EntityNotFoundException("Task not found with id " + taskId);
        }
        // Delete the task
        taskRepository.deleteById(taskId);
    }

    public List<Task> filterByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    // Filter tasks by priority
    public List<Task> filterByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    // Filter tasks by due date
    public List<Task> filterByDueDate(LocalDate dueDate) {
        return taskRepository.findByDueDate(dueDate);
    }



    // Search tasks
    public List<Task> searchTasks(String searchTerm) {
        return taskRepository.searchByTitleOrDescription(searchTerm);
    }



}
