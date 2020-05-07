package ru.otus.spring.service;

import java.util.List;

public interface PropertyService {

    String getByName(String name);

    String getByNameWithArgs(String name, List<String> args);
}
