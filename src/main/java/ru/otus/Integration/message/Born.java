package ru.otus.Integration.message;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import ru.otus.Integration.domain.Children;

@MessagingGateway
public interface Born {

    @Gateway(requestChannel = "eventChildChannel", replyChannel = "childChannel")
    Children process(String s);
}
