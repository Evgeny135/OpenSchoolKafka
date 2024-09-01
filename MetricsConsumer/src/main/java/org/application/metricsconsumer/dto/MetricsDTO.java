package org.application.metricsconsumer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Schema(description = "Шаблон для отправки метрик")
public class MetricsDTO {

    @Schema(description = "id метрики",example = "1")
    private Long id;
    @Schema(description = "название метрики",example = "Метрика производительности")
    private String name;
    @Schema(description = "Описание метрики",example = "Метрика служит содержит значение производительности")
    private String description;

    @Schema(description = "Значение метрики",example = "25")
    private Double value;
    @Schema(description = "Дата и время метрики")
    private LocalDateTime timeStamp;

    public MetricsDTO(Long id, String name, String description, Double value, LocalDateTime timeStamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.timeStamp = timeStamp;
    }

    public MetricsDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
