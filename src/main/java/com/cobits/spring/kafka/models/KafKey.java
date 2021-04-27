package com.cobits.spring.kafka.models;

import lombok.Data;

@Data
public class KafKey {
    private String key = KafKey.class.getName();
}
