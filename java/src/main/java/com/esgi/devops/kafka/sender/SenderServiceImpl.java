package com.esgi.devops.kafka.sender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class SenderServiceImpl implements SenderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String kafkaTopic;

    SenderServiceImpl(final KafkaTemplate<String, String> kafkaTemplate,
                      @Value("${kafka.topic.devops}") final String kafkaTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTopic = kafkaTopic;
    }

    @Override
    public String sendMessageToKafka(final String message) {
        kafkaTemplate.send(kafkaTopic, message);
        return message;
    }
}
