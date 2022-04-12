package com.learning.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic = "StudentsList";

    @GetMapping("/{name}")
    public String publish(@PathVariable String name){
        kafkaTemplate.send(topic, "hi, " + name + " Welcome!");
        System.out.println("Data published");
        return "Data Published: " + name ;
    }
}
