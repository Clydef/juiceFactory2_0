package com.example.juiceFactory2_0.adapter;

public class USD implements Currency {
    private double amount;

    public USD(double amount) {
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
