package ru.otus.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.service.PropertyService;

import java.util.List;
import java.util.Locale;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final Locale locale;

    @Autowired
    private MessageSource messageSource;

    public PropertyServiceImpl(Locale locale) {
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
