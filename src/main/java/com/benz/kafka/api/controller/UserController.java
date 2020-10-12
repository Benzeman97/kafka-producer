package com.benz.kafka.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class UserController {

    private KafkaTemplate<String,String> kafkaTemplate;
    final private static String TOPIC="Kafka_Example";

    @Autowired
    public UserController(KafkaTemplate<String,String> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }

    @GetMapping("/publish/{msg}")
    public String publish(@PathVariable("msg") String message)
    {
         kafkaTemplate.send(TOPIC,message);

         return "published successfully";
    }
}
