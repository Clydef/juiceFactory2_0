package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.Invoice;

public class OnlineBankingStrategy implements PaymentStrategy {
    @Override
    public void pay(Invoice invoice) {
        double invoiceAmount = invoice.getTotalPrice();
        System.out.println(invoice.getOrder().getOrderNumber() + " is paid via Online Banking " + invoiceAmount);
    }
}
