package com.daaeboul.taskmanagementsystem.model;

import jakarta.persistence.*;


@Entity
@Table(name = "status")
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long id;
    @Column(name = "status_name", nullable = false, unique = true)
    private String name;

    public enum Status {
        TODO, IN_PROGRESS, DONE
    }

    // Constructor for JPA
    protected TaskStatus() {
    }

    //Public constructor for creating instances
    public TaskStatus(Status status) {
        this.name = status.name();
    }
}
