package com.esgi.devops.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Service
class ConsumerServiceImpl {

    private final CountDownLatch latch;

    ConsumerServiceImpl() {
        this.latch = new CountDownLatch(1);
    }

    @KafkaListener(topics = "${kafka.topic.devops}")
    public void consumeMessage(ConsumerRecord<?, ?> consumerRecord) {
        log.info("received payload='{}'", consumerRecord.toString());
        latch.countDown();
    }
}
