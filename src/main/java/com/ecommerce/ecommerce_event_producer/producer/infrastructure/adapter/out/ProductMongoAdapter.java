package com.ecommerce.ecommerce_event_producer.producer.infrastructure.adapter.out;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.Product;
import com.ecommerce.ecommerce_event_producer.producer.domain.port.out.ProductPort;
import com.ecommerce.ecommerce_event_producer.producer.infrastructure.repository.ProductRepository;

@Repository
public class ProductMongoAdapter implements ProductPort {

    private final ProductRepository productRepository;
    private final Random random = new Random();
    
    public ProductMongoAdapter(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product findRandomProduct() {

        List<com.ecommerce.ecommerce_event_producer.producer.domain.model.Product> allProducts = productRepository.findAll();
        if(allProducts.isEmpty()) {
            System.err.println("No products found in MongoDB. Populating with default products...");
            populateInitialProducts();
            allProducts = productRepository.findAll();
            if (allProducts.isEmpty()) {
                return new Product("P-000", "Default Product", BigDecimal.valueOf(10.0));   
            }
        }
        return allProducts.get(random.nextInt(allProducts.size()));
    }

    private void populateInitialProducts() {
        if (productRepository.count() == 0) {
            productRepository.save(new Product("P-101", "Laptop Pro", BigDecimal.valueOf(1200.00)));
            productRepository.save(new Product("P-102", "Smartphone X",BigDecimal.valueOf(800.00)));
            productRepository.save(new Product("P-103", "Wireless Headset",BigDecimal.valueOf(150.00)));
            productRepository.save(new Product("P-104", "Mechanical Keyboard",BigDecimal.valueOf(90.00)));
            productRepository.save(new Product("P-105", "Gaming Mouse",BigDecimal.valueOf(60.00)));
            System.out.println("Initial products populated in MongoDB.");
        }
    }
}
