package ru.otus.Integration.service;

import org.springframework.stereotype.Service;
import ru.otus.Integration.domain.Children;

@Service
public class Kindergarten {
    public Children go(Children children) {
        children.setAge(children.getAge() + 6);
        System.out.println("Садик закончил/ла : " + children.getName() + " ему/ей теперь " + children.getAge() + " лет");
        return children;
    }
}
