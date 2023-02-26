package com.example.juiceFactory2_0.adapter;

public class USDSRDConverter implements CurrencyConverter {
    private double exchangeRate;

    public USDSRDConverter(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency convert(Currency currency) {
        double amount = currency.getAmount() * exchangeRate;
        return new SRD(amount);
    }
}

