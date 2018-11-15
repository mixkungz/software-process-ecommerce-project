package com.sit.softwareprocess.EcommerceProject.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id){
        return paymentRepository.getOne(id);
    }
}
