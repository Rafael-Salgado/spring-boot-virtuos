package com.example.springboot.services.impl;

import com.example.springboot.models.Users;
import com.example.springboot.services.IUserService;
import com.example.springboot.services.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @MockBean
    UserRepository userRepository;

    @Test
   public void loginUser() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(new Users("karen", "maldonado", "karen@test.com", "", "123")));

        assertEquals("User Log", userService.loginUser("karen@test.com","123"));
    }

    @Test
    public void failLoginUser() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(new Users("karen", "maldonado", "karen@test.com", "", "123")));

        assertEquals("Invalid data", userService.loginUser("karen@test.com","567"));
    }
}