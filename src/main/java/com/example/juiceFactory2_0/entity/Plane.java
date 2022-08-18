package com.example.juiceFactory2_0.entity;

import com.example.juiceFactory2_0.service.Transport;

public class Plane implements Transport {

    public Plane() {
    }

    public String getName() {
        return "Plane";
    }

    public Double getDeliveryFee() {
        return 400.00;
    }

    @Override
    public String deliver() {
        return "Delivers by " + getName() + " with a delivery fee of " + getDeliveryFee();
    }
}
