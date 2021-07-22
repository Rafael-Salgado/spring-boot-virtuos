package com.example.springboot.services.impl;

import com.example.springboot.models.Users;
import com.example.springboot.services.IUserService;
import com.example.springboot.services.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Qualifier("Users")
public class UserServiceImpl implements IUserService {

    private static final String SUCCESS_LOGIN = "Success login.";
    private static final String FAIL_LOGIN = "Wrong credentials.";

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
    public String loginUser(String email, String password) {
        //Why a list?
        List<Users> users = userRepository.logUser(email, password);
        return (users != null && users.size() > 0)?SUCCESS_LOGIN:FAIL_LOGIN;
    }
}
