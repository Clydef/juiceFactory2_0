package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.Order;
import com.example.juiceFactory2_0.entity.PaymentMethod;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    private PaymentMethod paymentMethod;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentContext() {
    }

    public void usePaymentMethod(Order order) {
        this.paymentStrategy.pay(order);
    }

//    public void getPaymentMethod(Invoice invoice) {
//        if (invoice.getInvoice_method().contains(Set.of(paymentMethod.getPaymentMethodName()))) {
//
//        }
//    }
}
