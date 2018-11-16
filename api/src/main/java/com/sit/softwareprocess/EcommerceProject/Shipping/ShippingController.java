package com.sit.softwareprocess.EcommerceProject.Shipping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    @Autowired
    ShippingService shippingService;

    
}
