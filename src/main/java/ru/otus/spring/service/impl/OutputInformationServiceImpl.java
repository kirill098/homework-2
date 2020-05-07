package ru.otus.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;
import ru.otus.spring.service.OutputInformationService;

import java.util.Map;

@Service
public class OutputInformationServiceImpl implements OutputInformationService {

    @Override
    public void printTestResult(Map<Question, Answer> map) {
        map.entrySet().forEach(r ->
                System.out.println(
                        r.getKey().getDescription() + " " +
                        r.getValue().getDescription())
        );
    }

    @Override
    public void printQuestion(Question question) {
        System.out.println(question.getDescription());
    }

    @Override
    public void printText(String text) {
        System.out.println(text);
    }
}
