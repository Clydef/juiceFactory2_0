package com.example.juiceFactory2_0.adapter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
