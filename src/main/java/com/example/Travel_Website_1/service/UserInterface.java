package com.example.Travel_Website_1.service;


import com.example.Travel_Website_1.model.User;

import java.util.List;
import java.util.Set;

public interface UserInterface {
    public   User addUser(User user);


    User updateUser(Long userId, User user);

    List<User> getAllUsers();

    void save(User user);

    User findById(Long theId);

    void deleteById(long userId);
}