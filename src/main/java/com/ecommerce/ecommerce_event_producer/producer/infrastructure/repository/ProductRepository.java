package com.ecommerce.ecommerce_event_producer.producer.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
