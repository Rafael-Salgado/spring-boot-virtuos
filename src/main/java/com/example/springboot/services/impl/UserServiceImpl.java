package com.example.springboot.services.impl;

import com.example.springboot.models.Users;
import com.example.springboot.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    // TODO: Use JPA to connect to database
    private HashMap<Long, Users> usersMap = new HashMap<>();

    @Override
    public Users getUserById(long id) {
        return usersMap.get(id);
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        for (Map.Entry<Long, Users> user : usersMap.entrySet()) {
            users.add(user.getValue());
        }
        return users;
    }

    @Override
    public Users createUser(Users users) {
        usersMap.put(users.getId(), users);
        return usersMap.get(users.getId());
    }

    @Override
    public Users updateUser(Users users) {
        usersMap.put(users.getId(), users);
        return users;
    }

    @Override
    public Users deleteUser(Users users) {
        usersMap.remove(users.getId());
        return users;
    }

    @Override
    public Users loginUser(String email, String password) {
        Users logUsers = null;
        for (Map.Entry<Long, Users> user : usersMap.entrySet()) {
            Users usersTemp = user.getValue();
            if (usersTemp.getUser_email().equals(email) && usersTemp.getUser_password().equals(password)) {
                logUsers = usersTemp;
                break;
            }
        }
        return logUsers;
    }
}
