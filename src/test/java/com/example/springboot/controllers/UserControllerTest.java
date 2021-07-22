package com.example.springboot.controllers;

import com.example.springboot.models.Users;
import com.example.springboot.services.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)


public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    IUserService userService;

    @Test
    public void getUser()throws Exception{
            mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
                    .andExpect(status().isOk())
            .andExpect(jsonPath("user_name").value("karen"));
    }

    @Test
    public void getAllUsers() throws Exception {
        given(userService.getAllUsers()).willReturn(Arrays.asList(new Users("karen","maldonado","mata_","", ""),
                                                                    new Users("juan","Pascual","pascualito_","", "")));
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void createUser() throws Exception {
        given(userService.createUser(Mockito.any())).willReturn(new Users("Marcela","rubio","marce_rubio","12345678","abcd"));

                mockMvc.perform(MockMvcRequestBuilders.post("/newUser"))
                        .andExpect(status().isOk());
    }
}
