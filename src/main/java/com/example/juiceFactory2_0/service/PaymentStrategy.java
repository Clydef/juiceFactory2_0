package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.Order;

public interface PaymentStrategy {
    void pay(Order order);
}
