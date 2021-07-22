package com.example.springboot.services;

import com.example.springboot.models.Users;

import java.util.List;

public interface IUserService {
    Users getUserById(long id);
    Iterable<Users> getAllUsers();
    Users createUser(Users users);
    Users updateUser(Users users);
    String deleteUser(long id);
    String loginUser(String email, String password);
}
