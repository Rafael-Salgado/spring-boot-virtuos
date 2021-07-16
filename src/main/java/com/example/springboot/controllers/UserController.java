package com.example.springboot.controllers;

import com.example.springboot.models.Users;
import com.example.springboot.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

   /* public UserController(@Autowired IUserService services) {
        this.services = services;
        services.createUser(new User(0,"User1","Apellido1","email_1@gmail.com",12345678,"password_1"));
        services.createUser(new User(1,"User2","Apellido2","email_2@gmail.com",12345678,"password_2"));
        services.createUser(new User(2,"User3","Apellido3","email_3@gmail.com",12345678,"password_3"));
        services.createUser(new User(3,"User4","Apellido4","email_4@gmail.com",12345678,"password_4"));
    }*/

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id")int id) {
        Optional<Users> user = userRepository.findById(id);
        return user.get();
    }

    @GetMapping("/users")
    public @ResponseBody Iterable<Users> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping
    public @ResponseBody String createUser(@RequestBody Users users) {
        userRepository.save(users);
        return "Saved";
    }

   /* @GetMapping("/login")
    public User getUserByEmailAndPassw(@RequestParam String email, String password){
        return services.loginUser(email, password);
    }



    @DeleteMapping
    public User deleteUser(@RequestBody User user) {
        return services.deleteUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return services.updateUser(user);
    }*/
}
