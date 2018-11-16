package com.sit.softwareprocess.EcommerceProject.OrderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public OrderDetail createOrderDetail(int orderId, int productId, int amount){
        OrderDetail orderDetail = new OrderDetail(new CompositePrimaryKey(orderId,productId), amount);
        return orderDetailRepository.save(orderDetail);
    }
}
