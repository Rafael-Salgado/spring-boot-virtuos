package com.example.springboot.services;

import com.example.springboot.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
}
