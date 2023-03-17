package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.PaymentMethod;

import java.math.BigDecimal;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;
    private PaymentMethod paymentMethod;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentContext() {
    }

    public String usePaymentMethod(BigDecimal order) {
        return this.paymentStrategy.pay(order);
    }

//    public void getPaymentMethod(Invoice invoice) {
//        if (invoice.getInvoice_method().contains(Set.of(paymentMethod.getPaymentMethodName()))) {
//
//        }
//    }
}
