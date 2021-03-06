package com.sit.softwareprocess.EcommerceProject.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
}
