package com.sit.softwareprocess.EcommerceProject.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/payments"
    )
    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/payments/{id}"
    )
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentById(id);
        return new ResponseEntity<Payment>(payment,HttpStatus.OK);
    }
}
