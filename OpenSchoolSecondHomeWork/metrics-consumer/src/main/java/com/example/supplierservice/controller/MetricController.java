package com.example.supplierservice.controller;


import com.example.supplierservice.dto.MetricChart;
import com.example.supplierservice.dto.MetricDto;
import com.example.supplierservice.enums.MetricType;
import com.example.supplierservice.service.MetricService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/metrics")
@RequiredArgsConstructor
@Tag(name = "Контроллер для метрик")
public class MetricController {

    private final MetricService service;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получение списка всех метрик")
    public List<MetricDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получение конкретной метрики по ее идентификатору")
    public MetricDto show(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/chart")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Получение списка метрик с массивом данных и времени для построения графика",
            description = "Получение списка метрик с массивом данных и времени для построения графика" +
                    ",с самым большим и средним значением," +
                    "с возможностью запроса за период и фильтрацией по типу метрики "
    )
    public List<MetricChart> findAllForChart(@RequestParam(required = false) @Parameter(description = "Начальная дата для запроса списка метрик") Long dtStart,
                                             @RequestParam(required = false) @Parameter(description = "Конечная дата для запроса списка метрик") Long dtStop,
                                             @RequestParam(required = false) @Parameter(description = "Тип метрики") MetricType type) {
        return service.findAllForChart(dtStart, dtStop, type);
    }


}
