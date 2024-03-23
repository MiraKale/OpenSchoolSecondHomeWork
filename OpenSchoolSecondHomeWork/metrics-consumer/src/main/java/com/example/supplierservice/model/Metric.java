package com.example.supplierservice.model;

import com.example.supplierservice.enums.MetricType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "metric")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column(nullable = false)
    private MetricType type;
    @Column(nullable = false)
    private int value;


}
