package com.example.juiceFactory2_0.adapter;

import com.example.juiceFactory2_0.entity.Invoice;

public class LocalPrice implements LocalCurrency{
    Invoice invoice;
    @Override
    public double payInSRD() {
        return invoice.getTotalPrice();
    }
}
