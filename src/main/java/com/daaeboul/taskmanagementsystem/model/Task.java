package com.daaeboul.taskmanagementsystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task_title", nullable = false)
    @NotBlank(message = "Title is required")
    private String title;

    @Column(name = "task_description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "task_due_date", nullable = false)
    @NotNull(message = "Due date is required")
    @FutureOrPresent(message = "Due date must be in the present or future")
    private ZonedDateTime dueDate;

    @ManyToOne
    @NotNull(message = "Task status is required")
    @JoinColumn(name = "status_id", nullable = false)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(String title, String description, ZonedDateTime dueDate, TaskStatus status, User user) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.user = user;
    }
}
