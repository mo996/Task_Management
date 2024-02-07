package com.daaeboul.taskmanagementsystem.service;

import com.daaeboul.taskmanagementsystem.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(Long id);

    Task save(Task task);

    void deleteById(long id);
}
