package com.example.juiceFactory2_0.adapter;

import java.math.BigDecimal;

public class USD implements Currency {
    private BigDecimal amount;

    public USD(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }
}
