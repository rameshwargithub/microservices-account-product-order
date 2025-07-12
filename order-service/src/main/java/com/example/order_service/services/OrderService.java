package com.example.order_service.services;

import com.example.order_service.config.AppConfig;
import com.example.order_service.data.Account;
import com.example.order_service.data.Order;
import com.example.order_service.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppConfig appConfig;
    public Order createOrder(Order order) {
        Account user=restTemplate.getForObject(appConfig.getAccountBaseUrl()+"account/"+order.getUserId(),Account.class);

        if(user==null){
            return null;
        }

        return orderRepo.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    public Order getOrderByOrderId(String orderId) {
        return orderRepo.findByOrderId(orderId).orElseThrow();
    }

    public int deleteOrder(String orderId){
        return orderRepo.deleteByOrderId(orderId);
    }

//    public Order updateOrderByOrderId(String orderId) {
//        return orderRepo.findByOrderId(orderId).orElseThrow();
//    }
}
