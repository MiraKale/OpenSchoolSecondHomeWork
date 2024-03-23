package com.example.supplierservice.dto;

import com.example.supplierservice.enums.MetricType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Schema(description = "Сущность метрики для клиентского отображения на графики")
public class MetricChart {
    @Schema(description = "Тип метрики")
    private MetricType type;
    @Schema(description = "Массив значений метрики определенного типа за запрашиваемый период")
    private List<Integer> values = new ArrayList<>();
    @Schema(description = "Массив времени метрики для значений за запрашиваемый период")
    private List<Long> valuesDate = new ArrayList<>();
    @Schema(description = "Средне арифметического значение метрики за запрашиваемый период")
    private double averageValuesByPeriod;
    @Schema(description = "Самое большое значение метрики за запрашиваемый период")
    private int mostAnomalousValue;
}
