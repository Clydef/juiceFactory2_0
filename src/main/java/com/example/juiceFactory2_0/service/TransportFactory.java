package com.example.juiceFactory2_0.service;

import com.example.juiceFactory2_0.entity.Bus;
import com.example.juiceFactory2_0.entity.Customer;
import com.example.juiceFactory2_0.entity.Plane;

public class TransportFactory {

    public Transport getInstance(Customer customer) {
        if (!customer.getDistrict().isEmpty()) {
            if ("Nickerie".equals(customer.getDistrict())) {
                return new Plane();
            } else {
                return new Bus();
            }
        } else {
            return new UnavailableTransport();
        }
    }
}
