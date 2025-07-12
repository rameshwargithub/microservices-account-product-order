package com.example.order_service.controller;

import com.example.order_service.data.Order;
import com.example.order_service.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("order-apis")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    private String test(){
        return "ok";
    }
    @PostMapping("order")
    private ResponseEntity<Order> createOrder(@Valid @RequestBody Order order){
        Order order1=orderService.createOrder(order);
        if(order1!=null){
            return ResponseEntity.status(201).body(order1);
        }else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"user not valid");
        }
    }
    @GetMapping("order")
    private ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.status(201).body(orderService.getAllOrder());
    }
    @GetMapping("order/{orderId}")
    private ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId){
        return ResponseEntity.status(200).body(orderService.getOrderByOrderId(orderId));
    }
//    @PatchMapping("order/{orderId}")
//    private ResponseEntity<Order> updateOrderByOrderId(@PathVariable String orderId){
//        return ResponseEntity.status(201).body(orderService.updateOrderByOrderId(orderId));
//    }
    @DeleteMapping("order/{orderId}")
    private ResponseEntity<?> deleteOrderByOrderId(@PathVariable String orderId){
        boolean isDeleted=orderService.deleteOrder(orderId)==1;
        return isDeleted?ResponseEntity.status(200).body("product deleted successfully"):ResponseEntity.status(204).body("product not found");

    }
}
