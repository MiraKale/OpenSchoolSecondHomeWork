package com.example.supplierservice.service;

import com.example.supplierservice.dto.MetricChart;
import com.example.supplierservice.enums.MetricType;
import com.example.supplierservice.mapper.MetricMapper;
import com.example.supplierservice.model.Metric;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.supplierservice.utils.DateConvertor.toEpochSeconds;
/**
 * Класс - сервис,который группирует список метрик по их типу,и для каждого типа наполняет в отдельные массивы
 * значения и время метрик,находит самое большое и среднее значение метрики
 */
@Service
@RequiredArgsConstructor
public class MetricChartService {

    private final MetricMapper mapper;

    public List<MetricChart> getMetricsChart(List<Metric> metrics) {
        Map<MetricType, List<Metric>> metricsByType = metrics.stream().collect(Collectors.groupingBy(Metric::getType));

        List<MetricChart> metricChartList = new ArrayList<>();
        for (MetricType metricType : metricsByType.keySet()) {
            List<Metric> metricWithType = metricsByType.get(metricType);
            List<Integer> values = metricWithType.stream().map(Metric::getValue).toList();
            List<Long> valuesDate = metricWithType.stream().map(metric -> toEpochSeconds(metric.getTimestamp())).toList();
            double averageValuesByPeriod = values.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);
            int mostAnomalousValue = values.stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(0);

            MetricChart metricChart = mapper.toMetricChart(metricType, values, valuesDate, averageValuesByPeriod, mostAnomalousValue);
            metricChartList.add(metricChart);
        }

        return metricChartList;
    }
}
