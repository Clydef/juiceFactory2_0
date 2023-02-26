package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.Order;

import java.math.BigDecimal;

public class CashStrategy implements PaymentStrategy {
    @Override
    public void pay(Order order) {
        BigDecimal invoiceAmount = order.getTotalAmount();
        System.out.println(order.getOrderNumber() + " is paid via Cash " + invoiceAmount.toString());
    }
}
