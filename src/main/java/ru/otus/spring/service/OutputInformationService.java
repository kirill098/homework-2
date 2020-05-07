package ru.otus.spring.service;

import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;

import java.util.Map;

public interface OutputInformationService {

    void printTestResult(Map<Question, Answer> map);

    void printQuestion(Question question);

    void printText(String text);
}
