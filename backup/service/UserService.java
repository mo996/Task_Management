package com.daaeboul.taskmanagementsystem.service;

import com.daaeboul.taskmanagementsystem.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(long id);
}
