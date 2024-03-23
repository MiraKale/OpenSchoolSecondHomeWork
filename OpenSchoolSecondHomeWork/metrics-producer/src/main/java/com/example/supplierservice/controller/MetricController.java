package com.example.supplierservice.controller;


import com.example.supplierservice.dto.MetricDto;
import com.example.supplierservice.service.MetricService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/metrics")
@RequiredArgsConstructor
@Tag(name = "Контроллер для метрик")
public class MetricController {

    private final MetricService service;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Принимает метрики работы приложения в формате JSON")
    public void create(@RequestBody MetricDto metric) {
        service.createMetric(metric);
    }


}
