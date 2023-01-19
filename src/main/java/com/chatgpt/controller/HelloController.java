package com.chatgpt.controller;

import com.chatgpt.service.QuestionMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private QuestionMarkService questionMarkService;

    @GetMapping
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @PostMapping
    public int countQuestionMarks(@RequestBody String input) {
        return questionMarkService.countQuestionMarks(input);
    }

}