package com.example.juiceFactory2_0.service;

public class UnavailableTransport implements Transport {

    @Override
    public String deliver() {
        return "Unknown transport!";
    }
}
