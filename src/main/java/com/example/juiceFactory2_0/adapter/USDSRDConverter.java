package com.example.juiceFactory2_0.adapter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class USDSRDConverter implements CurrencyConverter {
    private BigDecimal exchangeRate;

    public USDSRDConverter(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency convert(Currency currency) {
        BigDecimal amount = currency.getAmount().multiply(exchangeRate).setScale(2, RoundingMode.CEILING);
        return new SRD(amount);
    }
}

