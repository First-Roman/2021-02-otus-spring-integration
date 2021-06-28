package ru.otus.Integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;

@Configuration
public class ChannelConfig {
    @Bean
    public QueueChannel eventChildChannel() {
        return MessageChannels.queue(10).get();
    }

    @Bean
    public PublishSubscribeChannel childChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public PublishSubscribeChannel firstGraduationChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public PublishSubscribeChannel SecondGraduationChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        return Pollers.fixedRate(100).maxMessagesPerPoll(2).get();
    }

    @Bean
    public IntegrationFlow childBornFlow() {
        return IntegrationFlows.from("eventChildChannel")
                .handle("maternityHome", "getBorn")
                .channel("childChannel")
                .get();
    }

    @Bean
    public IntegrationFlow childFirstStepFlow() {
        return IntegrationFlows.from("childChannel")
                .handle("kindergarten", "go")
                .channel("firstGraduationChannel")
                .get();
    }

    @Bean
    public IntegrationFlow childToPeopleFlow() {
        return IntegrationFlows.from("firstGraduationChannel")
                .handle("school", "learn")
                .channel("SecondGraduationChannel")
                .get();
    }
}
