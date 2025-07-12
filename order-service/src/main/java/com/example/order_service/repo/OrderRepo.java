package com.example.order_service.repo;

import com.example.order_service.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Optional<Order> findByOrderId(String orderId);

    int deleteByOrderId(String orderId);
}
