package ru.otus.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.service.TestService;

@ShellComponent
public class ShellMain {

    private final TestService testService;

    public ShellMain(TestService testService) {
        this.testService = testService;
    }

    @ShellMethod(value = "Start student test", key = {"s", "start"})
    public void shellStartStudentTest() {
           testService.startStudentTest();
    }
}
