package com.example.supplierservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Config {

    /**
     * Создаем топик в нашем брокере Кафки
     * С именем - metrics-topic c 1 партицией и без дополнительных реплик
     */
    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name("metrics-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
