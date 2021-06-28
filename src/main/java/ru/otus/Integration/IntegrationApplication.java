package ru.otus.Integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import ru.otus.Integration.message.Born;

@IntegrationComponentScan
@EnableIntegration
@SpringBootApplication
public class IntegrationApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(IntegrationApplication.class, args);
        Born born = ctx.getBean(Born.class);
        for (int i = 100; i > 0; i--) {
            born.process("Be born");
            Thread.sleep(1000);
        }

    }

}
