package com.sit.softwareprocess.EcommerceProject.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
}
