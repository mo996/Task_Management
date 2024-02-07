package com.daaeboul.taskmanagementsystem;

import com.daaeboul.taskmanagementsystem.dao.RoleRepository;
import com.daaeboul.taskmanagementsystem.dao.TaskRepository;
import com.daaeboul.taskmanagementsystem.dao.TaskStatusRepository;
import com.daaeboul.taskmanagementsystem.dao.UserRepository;
import com.daaeboul.taskmanagementsystem.model.Role;
import com.daaeboul.taskmanagementsystem.model.Task;
import com.daaeboul.taskmanagementsystem.model.TaskStatus;
import com.daaeboul.taskmanagementsystem.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class TaskManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementSystemApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, TaskRepository taskRepository, RoleRepository roleRepository, TaskStatusRepository taskStatusRepository) {
        return runner -> {
            createObjects(userRepository, taskRepository, roleRepository, taskStatusRepository);
        };
    }

    void createObjects(UserRepository userRepository, TaskRepository taskRepository, RoleRepository roleRepository, TaskStatusRepository taskStatusRepository){
        // Create and save roles
        Role adminRole = new Role(Role.RoleType.ROLE_ADMIN);
        Role userRole = new Role(Role.RoleType.ROLE_USER);
        roleRepository.save(adminRole);
        roleRepository.save(userRole);

        // Create and save users
        User admin = new User("adminUsername", "adminPassword", "Admin@mail.com", Set.of(adminRole, userRole));
        User user1 = new User("user1Username", "user1Password", "User1@mail.com", Set.of(userRole));
        User user2 = new User("user2Username", "user2Password", "User2@mail.com", Set.of(userRole));

        userRepository.save(admin);
        userRepository.save(user1);
        userRepository.save(user2);

        // Create and save status
        TaskStatus todo = new TaskStatus(TaskStatus.Status.TODO);
        TaskStatus inProgress = new TaskStatus(TaskStatus.Status.IN_PROGRESS);
        TaskStatus done = new TaskStatus(TaskStatus.Status.DONE);
        taskStatusRepository.save(todo);
        taskStatusRepository.save(inProgress);
        taskStatusRepository.save(done);

        // Create and save tasks for admin
        Task adminTask1 = new Task("Admin Task 1", "Complete system audit", LocalDate.now(), todo, admin);
        Task adminTask2 = new Task("Admin Task 2", "Review security protocols", LocalDate.now().plusDays(1), inProgress, admin);
        taskRepository.save(adminTask1);
        taskRepository.save(adminTask2);

        // Create and save tasks for user1
        Task user1Task1 = new Task("User1 Task 1", "Prepare monthly report", LocalDate.now(), todo, user1);
        Task user1Task2 = new Task("User1 Task 2", "Update client database", LocalDate.now().plusDays(1), inProgress, user1);
        taskRepository.save(user1Task1);
        taskRepository.save(user1Task2);

        // Create and save tasks for user2
        Task user2Task1 = new Task("User2 Task 1", "Draft project proposal", LocalDate.now(), done, user2);
        Task user2Task2 = new Task("User2 Task 2", "Organize team meeting", LocalDate.now().plusDays(1), inProgress, user2);
        taskRepository.save(user2Task1);
        taskRepository.save(user2Task2);
    }


}
