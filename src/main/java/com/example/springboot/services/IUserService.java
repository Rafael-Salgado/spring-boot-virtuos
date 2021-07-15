package com.example.springboot.services;

import com.example.springboot.models.User;

import java.util.List;

public interface IUserService {
    User getUserById(long id);
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(User user);
    User deleteUser(User user);
    User loginUser(String email, String password);
}
