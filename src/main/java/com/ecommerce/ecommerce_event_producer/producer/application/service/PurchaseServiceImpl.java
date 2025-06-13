package com.ecommerce.ecommerce_event_producer.producer.application.service;

import java.time.Instant;
import java.util.UUID;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.Product;
import com.ecommerce.ecommerce_event_producer.producer.domain.model.PurchaseEvent;
import com.ecommerce.ecommerce_event_producer.producer.domain.port.out.EventProducerPort;
import com.ecommerce.ecommerce_event_producer.producer.domain.port.out.ProductPort;
import com.ecommerce.ecommerce_event_producer.producer.domain.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService{

    private final ProductPort productPort;
    private final EventProducerPort eventProducerPort;

    public PurchaseServiceImpl (ProductPort productPort, EventProducerPort eventProducerPort){
        this.productPort = productPort;
        this.eventProducerPort = eventProducerPort;
    }

    @Override
    public void simulatePurchase() {
        Product product = productPort.findRandomProduct();
        if (product == null) {
            System.err.println("No product found to simulate purchase. Skipping event generation.");
            return;
        }

        PurchaseEvent event = new PurchaseEvent(
            UUID.randomUUID().toString(),
            product.id(),
            product.name(),
            product.price(),
            Instant.now().toString()
        );
        eventProducerPort.sendPurchaseEvent(event);
        System.out.println("Generated and sent event " + event);
    }
}
