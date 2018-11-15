package com.sit.softwareprocess.EcommerceProject.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/payments"
    )
    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/payments/{id}"
    )
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentById(id);
        return new ResponseEntity<Payment>(payment,HttpStatus.OK);
    }
}
