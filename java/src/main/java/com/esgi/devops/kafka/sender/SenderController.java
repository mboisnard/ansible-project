package com.esgi.devops.kafka.sender;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SenderController {

    private final SenderService senderService;

    public SenderController(final SenderService senderService) {
        this.senderService = senderService;
    }

    @GetMapping
    public String sendDefaultMessageToKafka() {
        return senderService.sendMessageToKafka("YOLO");
    }

    @GetMapping("{message}")
    public String sendCustomMessageToKafka(@PathVariable("message") final String message) {
        return senderService.sendMessageToKafka(message);
    }
}
