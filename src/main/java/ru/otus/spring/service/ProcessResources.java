package ru.otus.spring.service;

import ru.otus.spring.model.Question;

import java.util.List;

public interface ProcessResources {

    List<Question> readQuestions() throws Exception;
}
