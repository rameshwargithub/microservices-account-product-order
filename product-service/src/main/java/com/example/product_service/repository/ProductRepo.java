package com.example.product_service.repository;

import com.example.product_service.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product,Long> {
    Optional<Product> findByProductId(String productId);

    long deleteByProductId(String productId);
}
