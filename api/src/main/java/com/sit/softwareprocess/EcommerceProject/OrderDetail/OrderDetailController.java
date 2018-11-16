package com.sit.softwareprocess.EcommerceProject.OrderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;
    
}
