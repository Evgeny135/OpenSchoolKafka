package org.application.metricsconsumer.services;

import org.application.dto.MetricDTO;
import org.application.metricsconsumer.model.Metric;
import org.application.metricsconsumer.repositories.MetricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private final MetricsRepository metricsRepository;

    @Autowired
    public KafkaService(MetricsRepository metricsRepository) {
        this.metricsRepository = metricsRepository;
    }

    @KafkaListener(topics = "metrics-topic", groupId = "listener",containerFactory = "kafkaListenerContainerFactory")
    public void list(MetricDTO metricDTO){
        Metric metric = new Metric();
        metric.setName(metricDTO.getName());
        metric.setDescription(metricDTO.getDescription());
        metric.setValue(metricDTO.getValue());
        metric.setTimeStamp(metricDTO.getTime());

        metricsRepository.save(metric);
    }
}
