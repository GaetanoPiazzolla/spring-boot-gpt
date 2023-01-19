package com.chatgpt.service;

import org.springframework.stereotype.Service;

@Service
public class QuestionMarkService {

    public int countQuestionMarks(String input) {
        return (int) input.chars().filter(c -> c == '?').count();
    }
}