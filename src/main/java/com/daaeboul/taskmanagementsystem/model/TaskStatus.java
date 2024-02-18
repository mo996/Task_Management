package com.daaeboul.taskmanagementsystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "taskstatus")
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long id;
    @Column(name = "status_name", nullable = false, unique = true)
    private String name;

    // Constructor for JPA
    protected TaskStatus() {
    }

    //Public constructor for creating instances
    public TaskStatus(String name) {
        this.name = name;
    }
}
