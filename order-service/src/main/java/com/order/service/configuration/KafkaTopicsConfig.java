package com.order.service.configuration;

//package com.example.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicsConfig {
 @Bean
 public NewTopic orderPlacedTopic() {
     return TopicBuilder.name("order.placed.v1")
             .partitions(3)
             .replicas(1)
             .build();
 }

 @Bean
 public NewTopic orderPlacedDlt() {
     return TopicBuilder.name("order.placed.v1.dlt")
             .partitions(3)
             .replicas(1)
             .build();
 }
}

