package org.application.metricsproducer.services;

import org.application.dto.MetricDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {

    private final String TOPIC = "metrics-topic";

    private final KafkaTemplate<String, MetricDTO> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, MetricDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(List<MetricDTO> metricDTOList){
        for (MetricDTO metricDTO : metricDTOList) {
            kafkaTemplate.send(TOPIC, metricDTO);
        }
    }
}
