package com.daaeboul.taskmanagementsystem;

import com.daaeboul.taskmanagementsystem.model.Role;
import com.daaeboul.taskmanagementsystem.model.Task;
import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import com.daaeboul.taskmanagementsystem.model.User;
import com.daaeboul.taskmanagementsystem.service.TaskService;
import com.daaeboul.taskmanagementsystem.service.TaskStatusService;
import com.daaeboul.taskmanagementsystem.service.RoleService;
import com.daaeboul.taskmanagementsystem.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class DataConfiguration {

    @Bean
    CommandLineRunner initData(UserService userService, TaskService taskService, RoleService roleService, TaskStatusService taskStatusService) {
        return args -> {

            // Create and save roles
            Role adminRole = roleService.findRoleById(1L).orElseThrow();
            Role userRole = roleService.findRoleById(2L).orElseThrow();

            // Create and save status
            TaskStatus todo = taskStatusService.findTaskStatusById(1L).orElseThrow();
            TaskStatus inProgress = taskStatusService.findTaskStatusById(2L).orElseThrow();
            TaskStatus done = taskStatusService.findTaskStatusById(3L).orElseThrow();

            // Additional users creation
            User newUser1 = new User("newUser", "newUserPassword", "NewUser@mail.com", userRole);
            User newUser2 = new User("newAdmin", "newAdminPassword", "NewAdmin@mail.com", adminRole);
            userService.saveUser(newUser1);
            userService.saveUser(newUser2);

            // Additional tasks creation (not assigned to any user)
            Task newTask1 = new Task("New Task 1", "Task description 1", ZonedDateTime.now(), todo, null);
            Task newTask2 = new Task("New Task 2", "Task description 2", ZonedDateTime.now().plusDays(1), inProgress, null);
            taskService.saveTask(newTask1);
            taskService.saveTask(newTask2);
        };
    }


}
