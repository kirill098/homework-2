package ru.otus.spring.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.spring.model.Question;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class ProcessResourcesImplTest {

    @MockBean
    private PropertyServiceImpl propertyService;

    @Autowired
    private ProcessResourcesImpl processResources;

    @BeforeEach
    void setUp() {
        processResources = new ProcessResourcesImpl(propertyService);
    }

    @Test
    public void shouldReadQuestions() throws Exception {
        String filePath = "src/main/resources/questions_en.csv";
        given(this.propertyService.getByName(any())).willReturn(filePath);
        List<Question> list = processResources.readQuestions();
        Question expected = new Question("What is your surname?");
        Question actual = list.get(0);
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}