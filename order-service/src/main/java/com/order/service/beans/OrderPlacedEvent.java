package com.order.service.beans;

//package com.example.events;
import lombok.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class OrderPlacedEvent {
 private String eventVersion;   // "1.0"
 private String eventType;      // "ORDER_PLACED"
 private String orderId;
 private String userId;
 private BigDecimal amount;
 private String currency;
 private List<Item> items;
 private Instant createdAt;
 private String traceId;

 @Data @NoArgsConstructor @AllArgsConstructor @Builder
 public static class Item {
     private String sku;
     private Integer qty;
     private BigDecimal price;
 }
}
