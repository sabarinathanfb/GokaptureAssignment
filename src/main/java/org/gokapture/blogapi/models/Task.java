package org.gokapture.blogapi.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Task extends BaseModel {

    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public enum Status {
        TODO,
        IN_PROGRESS,
        DONE
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

}
