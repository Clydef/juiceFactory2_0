package com.example.juiceFactory2_0.adapter;

import java.math.BigDecimal;

public class SRD implements Currency {
    private BigDecimal amount;

    public SRD(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }
}
