package com.example.supplierservice.service;

import com.example.supplierservice.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {
    /** Поле название топика,куда мы отправляем метрики */
    @Value("${topic.name}")
    private String topicName;
    /** Поле класса ответственный,за отправку сообщений в брокер */
    private final KafkaTemplate<String, Object> kafkaTemplate;
    /**
     * Метод отправляет полученную метрику в брокер и логирует ее
     * @param metric - метрика,которую необходимо отправить в брокер
     */
    public void send(MetricDto metric) {
        kafkaTemplate.send(topicName, metric);
        log.info("metric produced {}", metric);
    }
}
