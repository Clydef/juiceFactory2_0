package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.PaymentMethod;

import java.math.BigDecimal;

public class MopeStrategy implements PaymentStrategy {
    @Override
    public String pay(BigDecimal order) {
        return "Paid via " + PaymentMethod.MOPÉ;
    }
}
