package com.daaeboul.taskmanagementsystem.dao;

import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}
