package ru.otus.spring.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.spring.model.Question;
import ru.otus.spring.service.InputInformationService;
import ru.otus.spring.service.OutputInformationService;
import ru.otus.spring.service.PropertyService;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class TestServiceImplTest {

    @MockBean
    private ProcessResourcesImpl processResources;

    @Autowired
    private TestServiceImpl testService;

    @BeforeEach
    public void setUp() {
        testService = new TestServiceImpl(mock(OutputInformationService.class),
                mock(InputInformationService.class),
                processResources,
                mock(PropertyService.class));
    }

    @Test
    void shouldStartStudentTestSuccess() throws Exception {
        given(this.processResources.readQuestions()).willReturn(List.of(new Question("test")));
        testService.startStudentTest();
    }

    @Test
    void shouldStartStudentTestError() throws Exception {
        given(this.processResources.readQuestions()).willThrow(Exception.class);
        testService.startStudentTest();
    }

}