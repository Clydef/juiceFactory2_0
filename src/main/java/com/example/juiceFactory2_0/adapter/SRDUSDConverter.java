package com.example.juiceFactory2_0.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SRDUSDConverter implements CurrencyConverter {

    private BigDecimal exchangeRate;

    public SRDUSDConverter(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public Currency convert(Currency currency) {
        BigDecimal amount = currency.getAmount().divide(exchangeRate, 2, RoundingMode.HALF_UP);
        return new USD(amount) ;
    }
}
