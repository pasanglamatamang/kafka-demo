package com.learning.kafkademo;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaListeners {
    @KafkaListener(
            topics = "StudentsList",
            groupId = "groupId"
    )
    void listener(String data){
        System.out.println("Kafka listener received: " + data + " 🎉");
    }
}
