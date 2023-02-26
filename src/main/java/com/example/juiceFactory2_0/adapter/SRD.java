package com.example.juiceFactory2_0.adapter;

public class SRD implements Currency {
    private double amount;

    public SRD(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
