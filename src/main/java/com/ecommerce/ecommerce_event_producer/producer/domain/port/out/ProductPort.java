package com.ecommerce.ecommerce_event_producer.producer.domain.port.out;

import com.ecommerce.ecommerce_event_producer.producer.domain.model.Product;

public interface ProductPort {
    Product findRandomProduct();
}
