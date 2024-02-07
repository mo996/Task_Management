package com.daaeboul.taskmanagementsystem.rest;

import com.daaeboul.taskmanagementsystem.model.Role;
import com.daaeboul.taskmanagementsystem.model.User;
import com.daaeboul.taskmanagementsystem.rest.exceptionHandling.user.UserNotFoundException;
import com.daaeboul.taskmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable long userId) {
        User user = userService.findById(userId);
        if (user == null)
            throw new UserNotFoundException("User id not found - " + userId);
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0L);
        User dbUser = userService.save(user);
        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        User dbUser = userService.save(user);
        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable long userId){
        User tempUser = userService.findById(userId);
        if (tempUser == null)
            throw new UserNotFoundException("User id not found - " + userId);

        userService.deleteById(userId);
        return "Deleted user id - " + userId;
    }
}
