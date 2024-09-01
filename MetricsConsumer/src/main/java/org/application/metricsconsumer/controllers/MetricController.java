package org.application.metricsconsumer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.application.dto.MetricDTO;
import org.application.metricsconsumer.dto.MetricsDTO;
import org.application.metricsconsumer.services.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Получение метрик")
public class MetricController {

    private final MetricsService metricsService;

    @Autowired
    public MetricController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @GetMapping("/metrics")
    @Operation(summary = "Запрос для тестирования (доступен только для пользователя)",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Успешный запрос",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MetricsDTO.class))))
    })
    public ResponseEntity<List<MetricsDTO>> getAllMetrics() {
        try {
            return ResponseEntity.ok(metricsService.getAllMetrics());
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/metrics/{id}")
    @Operation(summary = "Запрос для тестирования (доступен только для пользователя)",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Успешный запрос",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MetricsDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Не найдено метрики")
            })
    public ResponseEntity<MetricsDTO> getMetricById(@PathVariable @Parameter(description = "Id метрики") long id) {
        try {
            MetricsDTO metric = metricsService.getMetricById(id);
            return ResponseEntity.ok(metric);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
