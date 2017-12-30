package com.esgi.devops.kafka.sender;

interface SenderService {

    String sendMessageToKafka(String message);
}
