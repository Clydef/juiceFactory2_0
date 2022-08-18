package com.example.juiceFactory2_0.entity;

import com.example.juiceFactory2_0.service.Transport;

public class Bus implements Transport {

    public Bus() {
    }

    public String getName() {
        return "Bus";
    }

    public Double getDeliveryFee() {
        return 100.00;
    }

    @Override
    public String deliver() {
        return "Delivers by " + getName() + " with a delivery fee of " + getDeliveryFee();
    }
}
