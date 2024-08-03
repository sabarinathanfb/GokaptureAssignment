package org.gokapture.blogapi.repositories;

import org.gokapture.blogapi.models.Task;
import org.gokapture.blogapi.models.enums.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByTitle(String title);

    Task findById(long id);

    List<Task> findByStatus(TaskStatus status);

    // Filter by priority
    List<Task> findByPriority(String priority);

    // Filter by due date
    List<Task> findByDueDate(LocalDate dueDate);

    // Search by title or description
    @Query("SELECT t FROM Task t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(t.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    List<Task> searchByTitleOrDescription(@Param("searchTerm") String searchTerm);

    Page<Task> findAll(Pageable pageable);


}
