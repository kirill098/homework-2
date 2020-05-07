package ru.otus.spring.service.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.service.PropertyService;

import java.util.List;
import java.util.Locale;

@Service
public class PropertyServiceImpl implements PropertyService {

    private MessageSource messageSource;
    private Locale locale;

    public PropertyServiceImpl(MessageSource messageSource, Locale locale) {
        this.messageSource = messageSource;
        this.locale = locale;
    }

    @Override
    public String getByName(String name) {
        return messageSource.getMessage(name, null, locale);
    }

    @Override
    public String getByNameWithArgs(String name, List<String> args) {
        return messageSource.getMessage(name, args.toArray(), locale);
    }
}
