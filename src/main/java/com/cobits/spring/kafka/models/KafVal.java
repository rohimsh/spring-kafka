package com.cobits.spring.kafka.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class KafVal {
    private LocalDateTime dateTime;
    private UUID uuid;
    private long millis;

    public KafVal(final LocalDateTime dateTime, final UUID uuid, final Long millis){
        this.dateTime = dateTime;
        this.millis = millis;
        this.uuid = uuid;
    }
}
