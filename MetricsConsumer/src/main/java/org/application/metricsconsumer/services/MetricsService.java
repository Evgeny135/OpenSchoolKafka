package org.application.metricsconsumer.services;

import org.application.dto.MetricDTO;
import org.application.metricsconsumer.dto.MetricsDTO;
import org.application.metricsconsumer.model.Metric;
import org.application.metricsconsumer.repositories.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MetricsService {

    private final MetricsRepository metricsRepository;

    @Autowired
    public MetricsService(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    public List<MetricsDTO> getAllMetrics(){
        List<Metric> all = metricsRepository.findAll();

        List<MetricsDTO> metricsDTOS = new ArrayList<>();
        for (Metric metric : all) {
            MetricsDTO metricsDTO = new MetricsDTO(metric.getId(),
                    metric.getName(), metric.getDescription(), metric.getValue(), metric.getTimeStamp());

            metricsDTOS.add(metricsDTO);
        }
        return metricsDTOS;
    }

    public MetricsDTO getMetricById(Long id){
        Optional<Metric> metricOptional = metricsRepository.findById(id);
        if (metricOptional.isPresent()) {
            Metric metric = metricOptional.get();
            MetricsDTO metricsDTO = new MetricsDTO(metric.getId(),
                    metric.getName(), metric.getDescription(), metric.getValue(), metric.getTimeStamp());

            return metricsDTO;
        }else throw new RuntimeException("Отсутсвует");
    }
}
