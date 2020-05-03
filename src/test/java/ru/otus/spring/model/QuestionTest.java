package ru.otus.spring.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@JsonTest
@RunWith(SpringRunner.class)
class QuestionTest {

    @Autowired
    private JacksonTester<Question> converter;

    @Test
    void shouldDeserialize() throws IOException {
        String json = "{\"description\":\"test_description\"}";
        Assertions.assertThat(this.converter.parse(json))
                .isEqualToComparingFieldByField(new Question("test_description"));
    }
}