package com.benz.kafka.api.controller;

import com.benz.kafka.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
@RequestMapping("/kafka")
public class UserController {

    private KafkaTemplate<String,User> kafkaTemplate;
    final private static String TOPIC="Kafka_Example_Json";

    @Autowired
    public UserController(KafkaTemplate<String,User> kafkaTemplate)
    {
        this.kafkaTemplate=kafkaTemplate;
    }

    @GetMapping("/publish/{name}")
    public String publish(@PathVariable("name") String name)
    {
        User user=new User(1001,name,12000.0);
         kafkaTemplate.send(TOPIC,user);

         return "published successfully";
    }
}
