package ru.otus.spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import ru.otus.spring.model.Answer;
import ru.otus.spring.model.Question;
import ru.otus.spring.service.InputInformationService;
import ru.otus.spring.service.OutputInformationService;
import ru.otus.spring.service.ProcessResources;
import ru.otus.spring.service.PropertyService;
import ru.otus.spring.service.TestService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    private final OutputInformationService outputInformationService;
    private final InputInformationService inputInformationService;
    private final ProcessResources processResources;
    private final PropertyService propertyService;

    public TestServiceImpl(
            OutputInformationService outputInformationService,
            InputInformationService inputInformationService,
            ProcessResources processResources,
            PropertyService propertyService) {
        this.outputInformationService = outputInformationService;
        this.inputInformationService = inputInformationService;
        this.processResources = processResources;
        this.propertyService = propertyService;
    }

    @Override
    public void startStudentTest() {
        printWelcomeMsg();
        Map<Question, Answer> result = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        getQuestions().forEach(q -> {
            outputInformationService.printQuestion(q);
            Answer answer = inputInformationService.getAnswer();
            result.put(q, answer);
        });
        stopWatch.stop();
        outputInformationService.printTestResult(result);
        printEndMsg(Double.toString(stopWatch.getTotalTimeSeconds()));
    }

    private List<Question> getQuestions() {
        try {
            return processResources.readQuestions();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return Collections.emptyList();
        }
    }

    private void printWelcomeMsg() {
        String msg = propertyService.getByName("msg.welcome");
        outputInformationService.printText(msg);
    }

    private void printEndMsg(String time) {
        String msg = propertyService.getByNameWithArgs("msg.end", List.of(time));
        outputInformationService.printText(msg);
    }
}
