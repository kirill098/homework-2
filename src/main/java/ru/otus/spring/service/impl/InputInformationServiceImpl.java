package ru.otus.spring.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.model.Answer;
import ru.otus.spring.service.InputInformationService;

import java.util.Scanner;

@Service
public class InputInformationServiceImpl implements InputInformationService {

    private Scanner scanner;

    public InputInformationServiceImpl() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Answer getAnswer() {
        String answer = scanner.nextLine();
        return new Answer(answer);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
