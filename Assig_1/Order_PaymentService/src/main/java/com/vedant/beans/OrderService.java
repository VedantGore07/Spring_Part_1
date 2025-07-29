package com.vedant.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    public void placeOrder() {
        System.out.println("Placing order...");
        paymentService.processPayment();
    }
}
