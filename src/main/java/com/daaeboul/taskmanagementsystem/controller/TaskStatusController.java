package com.daaeboul.taskmanagementsystem.controller;

import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import com.daaeboul.taskmanagementsystem.service.TaskStatusService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/taskstatuses")
public class TaskStatusController {


    private final TaskStatusService taskStatusService;

    @Autowired
    public TaskStatusController(TaskStatusService taskStatusService) {
        this.taskStatusService = taskStatusService;
    }

    // Create or update a TaskStatus
    @PostMapping
    public ResponseEntity<TaskStatus> saveOrUpdateTaskStatus(@Valid @RequestBody TaskStatus taskStatus) {
        TaskStatus savedTaskStatus = taskStatusService.saveTaskStatus(taskStatus);
        return ResponseEntity.ok(savedTaskStatus);
    }

    @GetMapping
    public ResponseEntity<List<TaskStatus>> getAllTaskStatuses() {
        List<TaskStatus> taskStatuses = taskStatusService.findAllTaskStatuses();
        return ResponseEntity.ok(taskStatuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskStatus> getTaskStatusById(@PathVariable Long id) {
        return taskStatusService.findTaskStatusById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskStatus(@PathVariable Long id) {
        taskStatusService.deleteTaskStatus(id);
        return ResponseEntity.ok().build();
    }
}
