package com.example.springboot.services;

import com.example.springboot.models.Users;

import java.util.List;

public interface IUserService {
    Users getUserById(long id);
    List<Users> getAllUsers();
    Users createUser(Users users);
    Users updateUser(Users users);
    Users deleteUser(Users users);
    Users loginUser(String email, String password);
}
