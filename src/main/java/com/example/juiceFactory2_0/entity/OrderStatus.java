package com.example.juiceFactory2_0.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties("order")
@Entity
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToMany(mappedBy = "orderStatus")
    private Set<Order> order;
    @Column
    private String orderState;

    public OrderStatus(Long id, Set<Order> order, String orderState) {
        this.id = id;
        this.order = order;
        this.orderState = orderState;
    }

    public OrderStatus() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Order> getOrder() {
        return order;
    }

    public void setOrder(Set<Order> order) {
        this.order = order;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", order=" + order +
                ", orderState='" + orderState + '\'' +
                '}';
    }
}
