package com.ecommerce.ecommerce_event_producer.producer.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "processed_events")
public record ProcessedEvent(@Id String id, String originalEventId, String status, String processedTimestamp) {}
