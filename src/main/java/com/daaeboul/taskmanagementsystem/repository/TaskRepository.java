package com.daaeboul.taskmanagementsystem.repository;

import com.daaeboul.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
