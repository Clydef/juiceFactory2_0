package com.example.juiceFactory2_0.service;

import java.math.BigDecimal;

public interface PaymentStrategy {
    String pay(BigDecimal order);
}
