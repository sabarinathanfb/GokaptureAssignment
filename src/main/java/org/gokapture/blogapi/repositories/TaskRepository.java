package org.gokapture.blogapi.repositories;

import org.gokapture.blogapi.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByTitle(String title);

    Task findById(long id);
}
