package com.chatgpt.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

    @InjectMocks
    private QuestionMarkService questionService;

    @Test
    public void testCountQuestionMarks_oneQuestionMark() {
        String input = "How many question marks are there in this sentence?";
        int expectedCount = 1;

        int actualCount = questionService.countQuestionMarks(input);

        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    public void testCountQuestionMarks_twoQuestionMarks() {
        String input = "Are you sure???";
        int expectedCount = 2;

        int actualCount = questionService.countQuestionMarks(input);

        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    public void testCountQuestionMarks_noQuestionMark() {
        String input = "There are no question marks here";
        int expectedCount = 0;

        int actualCount = questionService.countQuestionMarks(input);

        assertThat(actualCount).isEqualTo(expectedCount);
    }
}
