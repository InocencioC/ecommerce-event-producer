package com.ecommerce.ecommerce_event_producer.producer.domain.model;

import java.math.BigDecimal;

public record PurchaseEvent(String eventId, String productId, String productName, BigDecimal price, String timestamp) {
}
