package ru.otus.Integration.service;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import ru.otus.Integration.domain.Children;

@Service
public class MaternityHome {
    private String[] names = {"Петя", "Маша", "Алена", "Саша", "Дмитрий", "Денис", "Роман", "Роза", "Марина", "Света"};

    public Children getBorn() {
        String name = names[RandomUtils.nextInt(0, names.length)];
        System.out.println("На свет появился/сь :" + name + " Ура!!!)");
        return new Children(name, 0);
    }
}
