package com.example.juiceFactory2_0.adapter;

public class SRDUSDConverter implements CurrencyConverter {

    private double exchangeRate;

    public SRDUSDConverter(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public Currency convert(Currency currency) {
        double amount = currency.getAmount() * exchangeRate;
        return new USD(amount) ;
    }
}
