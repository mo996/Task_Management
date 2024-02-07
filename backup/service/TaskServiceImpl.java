package com.daaeboul.taskmanagementsystem.service;

import com.daaeboul.taskmanagementsystem.dao.TaskRepository;
import com.daaeboul.taskmanagementsystem.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> result = taskRepository.findById(id);
        Task task = null;
        if (result.isPresent()) {
            task = result.get();
        }
        return task;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
