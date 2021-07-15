package com.example.springboot.services.impl;

import com.example.springboot.models.User;
import com.example.springboot.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    // TODO: Use JPA to connect to database
    private HashMap<Long, User> usersMap = new HashMap<>();

    @Override
    public User getUserById(long id) {
        return usersMap.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (Map.Entry<Long, User> user : usersMap.entrySet()) {
            users.add(user.getValue());
        }
        return users;
    }

    @Override
    public User createUser(User user) {
        usersMap.put(user.getId(), user);
        return usersMap.get(user.getId());
    }

    @Override
    public User updateUser(User user) {
        usersMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User deleteUser(User user) {
        usersMap.remove(user.getId());
        return user;
    }

    @Override
    public User loginUser(String email, String password) {
        User logUser = null;
        for (Map.Entry<Long, User> user : usersMap.entrySet()) {
            User userTemp = user.getValue();
            if (userTemp.getEmail().equals(email) && userTemp.getPassword().equals(password)) {
                logUser = userTemp;
                break;
            }
        }
        return logUser;
    }
}
