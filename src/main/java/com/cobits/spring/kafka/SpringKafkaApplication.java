package com.cobits.spring.kafka;

import com.cobits.spring.kafka.models.KafVal;
import com.cobits.spring.kafka.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class SpringKafkaApplication {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = SpringApplication.run(SpringKafkaApplication.class, args);
        while(true){
            Thread.sleep(1000);
            KafkaProducer kafkaProducer = ctx.getBean(KafkaProducer.class);
            kafkaProducer.sendMessage(new KafVal(LocalDateTime.now(), UUID.randomUUID(), System.currentTimeMillis()));
        }
    }
}
