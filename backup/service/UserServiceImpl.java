package com.daaeboul.taskmanagementsystem.service;


import com.daaeboul.taskmanagementsystem.dao.UserRepository;
import com.daaeboul.taskmanagementsystem.model.User;
import com.daaeboul.taskmanagementsystem.rest.exceptionHandling.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);
        User user = null;
        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new UserNotFoundException("Did not find user id - " + id);
        }
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
