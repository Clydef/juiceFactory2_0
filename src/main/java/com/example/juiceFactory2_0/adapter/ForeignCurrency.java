package com.example.juiceFactory2_0.adapter;

public class ForeignCurrency {
    private Double totalPriceInUSD;

    public ForeignCurrency(Double totalPriceInUSD) {
        this.totalPriceInUSD = totalPriceInUSD;
    }

    public Double getTotalPriceInUSD() {
        return totalPriceInUSD;
    }

    public void setTotalPriceInUSD(Double totalPriceInUSD) {
        this.totalPriceInUSD = totalPriceInUSD;
    }
}
