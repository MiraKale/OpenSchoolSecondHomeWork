package com.example.supplierservice.specification;

import com.example.supplierservice.enums.MetricType;
import com.example.supplierservice.model.Metric;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class MetricSpecification {

    private MetricSpecification() {
    }

    public static Specification<Metric> typeEqual(MetricType type) {
        return (root, query, builder) -> builder.equal(root.get("type"), type);
    }

    public static Specification<Metric> betweenDate(LocalDateTime dtStart, LocalDateTime dtStop) {
        return (root, query, builder) -> builder.between(root.get("timestamp"), dtStart, dtStop);
    }

}
