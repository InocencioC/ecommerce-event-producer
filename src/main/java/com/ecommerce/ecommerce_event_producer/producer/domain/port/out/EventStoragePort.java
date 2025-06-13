package com.ecommerce.ecommerce_event_producer.producer.domain.port.out;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.ProcessedEvent;

public interface EventStoragePort {
    void saveProcessedEvent(ProcessedEvent event);
}
