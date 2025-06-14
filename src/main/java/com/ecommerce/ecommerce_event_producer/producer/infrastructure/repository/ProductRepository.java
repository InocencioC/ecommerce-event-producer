package com.ecommerce.ecommerce_event_producer.producer.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
