package com.example.springboot.controllers;

import com.example.springboot.models.User;
import com.example.springboot.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    private final IUserService services;

    public UserController(@Autowired IUserService services) {
        this.services = services;
        services.createUser(new User(0,"User1","Apellido1","email_1@gmail.com",12345678,"password_1"));
        services.createUser(new User(1,"User2","Apellido2","email_2@gmail.com",12345678,"password_2"));
        services.createUser(new User(2,"User3","Apellido3","email_3@gmail.com",12345678,"password_3"));
        services.createUser(new User(3,"User4","Apellido4","email_4@gmail.com",12345678,"password_4"));
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam int id){
        return services.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return services.getAllUsers();
    }

    @GetMapping("/login")
    public User getUserByEmailAndPassw(@RequestParam String email, String password){
        return services.loginUser(email, password);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return services.createUser(user);
    }

    @DeleteMapping
    public User deleteUser(@RequestBody User user) {
        return services.deleteUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return services.updateUser(user);
    }
}
