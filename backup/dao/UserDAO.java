package com.daaeboul.taskmanagementsystem.dao;

import com.daaeboul.taskmanagementsystem.model.User;

import java.util.List;

public interface UserDAO {
    User save(User user);

    User findById(Long id);

    List<User> findAll();

    List<User> findByUsername(String username);

    void delete(long id);

}
