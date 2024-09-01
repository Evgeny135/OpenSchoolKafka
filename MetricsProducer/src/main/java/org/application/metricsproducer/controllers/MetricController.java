package org.application.metricsproducer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.application.dto.MetricDTO;
import org.application.metricsproducer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Контроллер для отправки метрик")
public class MetricController {

    private final ProducerService producerService;

    @Autowired
    public MetricController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/metrics")
    @Operation(summary = "Отправка метрик",responses = {
            @ApiResponse(responseCode = "200",
                    description = "Успешная отправка метрик",
                    content = @Content(mediaType = "text/plain",
                            schema = @Schema(type = "String", example = "Успешно отправленоы"))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка при отправке метрик"
            )
    })
    public ResponseEntity<String> index(@RequestBody @Parameter(description = "Отправка списка метрик") List<MetricDTO> metricDTO) {
        try {
            producerService.sendMessage(metricDTO);
            return ResponseEntity.ok("Успешно отправлено");
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
