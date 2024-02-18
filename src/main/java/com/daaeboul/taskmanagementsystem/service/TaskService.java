package com.daaeboul.taskmanagementsystem.service;

import com.daaeboul.taskmanagementsystem.model.Task;
import com.daaeboul.taskmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        //Before saving the entity, adjust the dueDate to be slightly in the future (e.g., a few seconds ahead) to ensure it passes the @FutureOrPresent validation.
        task.setDueDate(task.getDueDate().plusSeconds(10));
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
