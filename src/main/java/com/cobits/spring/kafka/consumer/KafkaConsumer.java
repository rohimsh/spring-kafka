package com.cobits.spring.kafka.consumer;

import com.cobits.spring.kafka.commons.Constants;
import com.cobits.spring.kafka.models.KafVal;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(autoStartup = "true", topics = Constants.TOPIC_COBITS, groupId = Constants.CONSUMER_GROUP_COBITS)
    public void listenGroupCoBits(KafVal message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
