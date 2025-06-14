package com.ecommerce.ecommerce_event_producer.producer.infrastructure.adapter.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.PurchaseEvent;
import com.ecommerce.ecommerce_event_producer.producer.domain.port.out.EventProducerPort;

@Component
public class KafkaProducerAdapter implements EventProducerPort {

    private final KafkaTemplate<String, PurchaseEvent> kafkaTemplate;

    public KafkaProducerAdapter(KafkaTemplate<String, PurchaseEvent> kafkaTemplate){
            this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendPurchaseEvent(PurchaseEvent event) {
        kafkaTemplate.send("purchase-events-topic", event.eventId(), event);
    } 
}
