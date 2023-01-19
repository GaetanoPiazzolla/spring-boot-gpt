package com.chatgpt.controller;

import com.chatgpt.controller.HelloController;
import com.chatgpt.interceptor.AuthorizationInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController)
                .addInterceptors(authorizationInterceptor)
                .build();
    }

    @Test
    public void testHelloEndpointWithUnauthorized() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testHelloEndpointWithAuthorized() throws Exception {
        mockMvc.perform(get("/hello").header("Authorization", "human"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Spring Boot!"));
    }
}
