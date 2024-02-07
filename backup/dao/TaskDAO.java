package com.daaeboul.taskmanagementsystem.dao;

import com.daaeboul.taskmanagementsystem.model.Task;
import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import com.daaeboul.taskmanagementsystem.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TaskDAO {
    Task save(Task task);

    Task findById(Long id);

    List<Task> findAll();

    List<Task> findByTitle(String title);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByDueDate(LocalDate date);

    List<Task> findByUser(User user);

    void delete(long id);
}
