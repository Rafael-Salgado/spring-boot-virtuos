package com.example.springboot.services.impl;

import com.example.springboot.models.Users;
import com.example.springboot.services.IUserService;
import com.example.springboot.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    // TODO: Use JPA to connect to database
    //private HashMap<Long, Users> usersMap = new HashMap<>();
    @Autowired
    UserRepository userRepository;

    @Transactional
    public Users getUserById(long id) {
        Optional<Users> user = userRepository.findById(id);
        return user.get();
    }

    @Transactional
    public Iterable<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Users createUser(Users users) {
        userRepository.save(users);

        return users;
    }

    @Override
    public Users updateUser(Users users) {
        userRepository.save(users);
        return users;
    }

    @Transactional
    public String deleteUser(long id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    @Transactional
    public String loginUser(String email, String password,long id) {
        Users logUsers = null;
        String message = "Invalid data";
        Optional<Users> user = userRepository.findById(id);

        if(user.isPresent()){
            if(user.get().getUser_email().equals(email)&&user.get().getUser_password().equals(password))
                message="User Log";
        }
        return message;
    }
}
