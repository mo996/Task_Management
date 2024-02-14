package com.daaeboul.taskmanagementsystem.service;

import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import com.daaeboul.taskmanagementsystem.repository.TaskStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskStatusService {

    private final TaskStatusRepository taskStatusRepository;

    @Autowired
    public TaskStatusService(TaskStatusRepository taskStatusRepository) {
        this.taskStatusRepository = taskStatusRepository;
    }

    public List<TaskStatus> findAllTaskStatuses() {
        return taskStatusRepository.findAll();
    }

    public Optional<TaskStatus> findTaskStatusById(Long id) {
        return taskStatusRepository.findById(id);
    }

    public TaskStatus saveTaskStatus(TaskStatus taskStatus) {
        return taskStatusRepository.save(taskStatus);
    }

    public void deleteTaskStatus(Long id) {
        taskStatusRepository.deleteById(id);
    }
}
