package com.ecommerce.ecommerce_event_producer.producer.infrastructure.adapter.out;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.ProcessedEvent;
import com.ecommerce.ecommerce_event_producer.producer.domain.port.out.EventStoragePort;
import com.ecommerce.ecommerce_event_producer.producer.infrastructure.repository.ProcessedEventRepository;

public class MongoEventStorageAdapter implements EventStoragePort {

    private final ProcessedEventRepository processedEventRepository;

    public MongoEventStorageAdapter(ProcessedEventRepository processedEventRepository) {
        this.processedEventRepository = processedEventRepository;
    }

    @Override
    public void saveProcessedEvent(ProcessedEvent event) {
    processedEventRepository.save(event);
    }

}
