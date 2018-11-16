package com.sit.softwareprocess.EcommerceProject.Shipping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public List<Shipping> getAllShipping(){

        List<Shipping> shipping = shippingRepository.findAll();
        return shipping;
    }
}
