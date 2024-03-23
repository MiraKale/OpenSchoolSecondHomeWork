package com.example.supplierservice.service;

import com.example.supplierservice.dto.MetricChart;
import com.example.supplierservice.dto.MetricDto;
import com.example.supplierservice.enums.MetricType;
import com.example.supplierservice.mapper.MetricMapper;
import com.example.supplierservice.model.Metric;
import com.example.supplierservice.repository.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.example.supplierservice.specification.MetricSpecification.betweenDate;
import static com.example.supplierservice.specification.MetricSpecification.typeEqual;
import static com.example.supplierservice.utils.DateConvertor.toDate;

@RequiredArgsConstructor
@Service
public class MetricService {
    private final MetricRepository repository;
    private final MetricChartService metricChartService;
    private final MetricMapper mapper;

    public void save(MetricDto metricDto) {
        Metric metric = mapper.toEntity(metricDto);
        repository.save(metric);
    }

    @Transactional
    public List<MetricDto> findAll() {
        List<Metric> metrics = repository.findAll();
        return mapper.toDtoList(metrics);
    }

    @Transactional
    public MetricDto findById(Long id) {
        Metric metric = repository.findById(id).orElseThrow();
        return mapper.toDto(metric);
    }

    @Transactional
    public List<MetricChart> findAllForChart(Long dtStartSeconds, Long dtStopSeconds, MetricType type) {
        Specification<Metric> filters = Specification
                .where((dtStartSeconds == null || dtStopSeconds == null) ? null : betweenDate(toDate(dtStartSeconds), toDate(dtStopSeconds)))
                .and(type == null ? null : typeEqual(type));

        List<Metric> metrics = repository.findAll(filters, Sort.by("timestamp"));

        return metricChartService.getMetricsChart(metrics);
    }
}
