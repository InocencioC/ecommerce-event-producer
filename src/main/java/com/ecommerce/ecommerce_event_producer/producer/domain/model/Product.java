package com.ecommerce.ecommerce_event_producer.producer.domain.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public record Product(@Id String id, String name, BigDecimal price) {}
