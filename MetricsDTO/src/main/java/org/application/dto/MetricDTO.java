package org.application.dto;


import java.time.LocalDateTime;

public class MetricDTO {
    private String name;
    private String description;
    private double value;
    private LocalDateTime time;

    public MetricDTO() {
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MetricDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", time=" + time +
                '}';
    }
}
