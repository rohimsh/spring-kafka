package com.cobits.spring.kafka.producer;

import com.cobits.spring.kafka.commons.Constants;
import com.cobits.spring.kafka.models.KafKey;
import com.cobits.spring.kafka.models.KafVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<KafKey, KafVal> kafkaTemplate;

    public void sendMessage(KafVal message) {
        ListenableFuture<SendResult<KafKey, KafVal>> future = kafkaTemplate.send(Constants.TOPIC_COBITS, message);
        future.addCallback(new ListenableFutureCallback<SendResult<KafKey, KafVal>>() {
            @Override
            public void onSuccess(SendResult<KafKey, KafVal> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
