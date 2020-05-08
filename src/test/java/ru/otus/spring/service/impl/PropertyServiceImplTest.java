package ru.otus.spring.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class PropertyServiceImplTest {

    @MockBean
    private MessageSource messageSource;

    @Autowired
    private PropertyServiceImpl propertyService;

    @Test
    void shouldGetByName() {
        given(this.messageSource.getMessage(any(), any(), any())).willReturn("test");
        String actual = propertyService.getByName("test_name");
        Assertions.assertEquals("test", actual);
    }

    @Test
    void shouldGetByNameWithArgs() {
        given(this.messageSource.getMessage(any(), any(), any())).willReturn("test");
        String actual = propertyService.getByNameWithArgs("test_name", List.of());
        Assertions.assertEquals("test", actual);
    }
}