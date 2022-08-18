package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.Invoice;

public interface PaymentStrategy {
    void pay(Invoice invoice);
}
