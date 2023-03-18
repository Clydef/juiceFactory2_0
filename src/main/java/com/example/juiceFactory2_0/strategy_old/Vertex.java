package com.example.juiceFactory2_0.strategy_old;

import com.example.juiceFactory2_0.entity.Customer;

public class Vertex {
    public Customer customer;
    public boolean wasVisited;
    public boolean isInTree;

    public Vertex(Customer customer) {
        this.customer = customer;
        wasVisited = false;
        isInTree = false;
    }
}
