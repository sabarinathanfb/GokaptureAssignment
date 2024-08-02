package org.gokapture.blogapi.services;

import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.repositories.TaskRepository;
import org.springframework.stereotype.Service;

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


}
