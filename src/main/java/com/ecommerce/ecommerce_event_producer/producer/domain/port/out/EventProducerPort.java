package com.ecommerce.ecommerce_event_producer.producer.domain.port.out;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.PurchaseEvent;

public interface EventProducerPort {
    void sendPurchaseEvent(PurchaseEvent event);
}
