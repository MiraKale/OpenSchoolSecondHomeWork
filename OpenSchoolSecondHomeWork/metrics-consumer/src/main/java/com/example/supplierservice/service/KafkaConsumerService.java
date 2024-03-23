package com.example.supplierservice.service;

import com.example.supplierservice.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerService {
    /** Поле название топика,откуда мы запрашиваем метрики */
    private static final String topicName = "${topic.name}";
    /** Поле название group id consumer */
    private static final String kafkaConsumerGroupId = "${spring.kafka.consumer.group-id}";
    /** Поле класса ответственный,за сохранение полученной из брокера метрики в БД */
    private final MetricService metricService;
    /**
     * Метод,который запрашивает из брокера и новые метрики
     * @param metric - метрика,которая была отправлена в брокер и которую мы получили из него
     */
    @KafkaListener(topics = topicName, groupId = kafkaConsumerGroupId)
    public void consumeMessage(MetricDto metric) {
        log.info("message consumed {}", metric);

        metricService.save(metric);
    }
}
