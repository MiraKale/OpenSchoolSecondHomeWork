package com.example.supplierservice.service;

import com.example.supplierservice.dto.MetricDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MetricService {
    private final KafkaProducerService kafkaProducerService;

    @Transactional
    public void createMetric(MetricDto metric) {
        kafkaProducerService.send(metric);
    }
}
