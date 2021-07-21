package com.example.springboot.controllers;

import com.example.springboot.models.Users;
import com.example.springboot.services.IUserService;
import com.example.springboot.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    IUserService services;

   /* public UserController(@Autowired IUserService services) {
        this.services = services;
        services.createUser(new User(0,"User1","Apellido1","email_1@gmail.com",12345678,"password_1"));
        services.createUser(new User(1,"User2","Apellido2","email_2@gmail.com",12345678,"password_2"));
        services.createUser(new User(2,"User3","Apellido3","email_3@gmail.com",12345678,"password_3"));
        services.createUser(new User(3,"User4","Apellido4","email_4@gmail.com",12345678,"password_4"));
    }*/

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") long id) {
        return services.getUserById(id);
    }

    @GetMapping("/users")
    public @ResponseBody
    Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return services.getAllUsers();
    }

    @GetMapping("/login")
    public @ResponseBody
    String getUserByEmailAndPassw(@RequestParam String email, String password,long id){
       return services.loginUser(email,password,id);
    }

    @PostMapping("/newUser")
    public @ResponseBody
    Users createUser(@RequestBody Users users) {
         return services.createUser(users);
    }

    @PutMapping("/updateUser")
    public @ResponseBody
    Users updateUser(@RequestBody Users users) {

        return services.updateUser(users);
    }
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String deleteUser(@PathVariable("id") long id) {
        return services.deleteUser(id);
    }





}
