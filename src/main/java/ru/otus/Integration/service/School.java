package ru.otus.Integration.service;

import org.springframework.stereotype.Service;
import ru.otus.Integration.domain.Children;
import ru.otus.Integration.domain.People;

@Service
public class School {
    public People learn(Children children) {
        String name = children.getName();
        int age = children.getAge() + 11;
        System.out.println("Поздравляем " + children.getName() + " теперь ты повзрослел!");
        return new People(name, age);
    }
}
