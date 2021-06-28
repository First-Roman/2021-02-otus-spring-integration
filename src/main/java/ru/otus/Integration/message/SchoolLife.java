package ru.otus.Integration.message;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.Integration.domain.Children;
import ru.otus.Integration.domain.People;

@MessagingGateway
public interface SchoolLife {

    @Gateway(requestChannel = "firstGraduationChannel", replyChannel = "SecondGraduationChannel")
    People process(Children children);
}
