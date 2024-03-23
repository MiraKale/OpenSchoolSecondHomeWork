package com.example.supplierservice.mapper;

import com.example.supplierservice.dto.MetricChart;
import com.example.supplierservice.dto.MetricDto;
import com.example.supplierservice.enums.MetricType;
import com.example.supplierservice.model.Metric;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Component
public class MetricMapper {

    public MetricDto toDto(Metric entity) {
        return MetricDto
                .builder()
                .timestamp(entity.getTimestamp().toEpochSecond(ZoneOffset.UTC))
                .type(entity.getType())
                .value(entity.getValue())
                .build();
    }

    public Metric toEntity(MetricDto dto) {
        return Metric
                .builder()
                .timestamp(LocalDateTime.ofEpochSecond(dto.getTimestamp(), 0, ZoneOffset.UTC))
                .type(dto.getType())
                .value(dto.getValue())
                .build();
    }

    public List<MetricDto> toDtoList(List<Metric> entityList) {
        return entityList.stream().map(this::toDto).toList();
    }

    public MetricChart toMetricChart(MetricType metricType,
                                     List<Integer> values,
                                     List<Long> valuesDate,
                                     double averageValuesByPeriod,
                                     int mostAnomalousValue) {
        MetricChart metricChart = new MetricChart();
        metricChart.setType(metricType);
        metricChart.setValues(values);
        metricChart.setValuesDate(valuesDate);
        metricChart.setAverageValuesByPeriod(averageValuesByPeriod);
        metricChart.setMostAnomalousValue(mostAnomalousValue);

        return metricChart;
    }
}
