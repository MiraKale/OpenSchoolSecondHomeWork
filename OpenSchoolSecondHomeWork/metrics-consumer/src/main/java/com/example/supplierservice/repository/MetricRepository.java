package com.example.supplierservice.repository;

import com.example.supplierservice.model.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends JpaRepository<Metric,Long>, JpaSpecificationExecutor<Metric> {
}
