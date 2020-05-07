package ru.otus.spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.otus.spring.model.Question;
import ru.otus.spring.service.ProcessResources;
import ru.otus.spring.service.PropertyService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ProcessResourcesImpl implements ProcessResources {

    private final PropertyService propertyService;

    public ProcessResourcesImpl(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Override
    public List<Question> readQuestions() throws Exception {
        List<Question> questions = new ArrayList<>();
        String pathToFile = propertyService.getByName("file.path");
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            while (scanner.hasNextLine()) {
                String description = scanner.nextLine();
                if (!StringUtils.isEmpty(description)) {
                    questions.add(new Question(description));
                }
            }
            return questions;
        }
    }
}
