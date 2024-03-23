package com.example.supplierservice.dto;


import com.example.supplierservice.enums.MetricType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность метрики")
public class MetricDto {

    @Schema(description = "Время в секундах,когда произошла метрика")
    private long timestamp;
    @Schema(description = "Тип метрики")
    private MetricType type;
    @Schema(description = "Значение метрики")
    private int value;
}
