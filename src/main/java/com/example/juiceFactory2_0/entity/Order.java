package com.example.juiceFactory2_0.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@JsonIgnoreProperties({"customer","orderProducts", "invoice", "orderStatus"})
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(nullable = false, updatable = false)
    private String orderNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private Set<OrderProducts> orderProducts;
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
    @Column
    private LocalDate orderDate;
    @Column
    private LocalDate deliveryDate;
    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    public Order(Long id, String orderNumber, Customer customer, Set<OrderProducts> orderProducts, Invoice invoice,
                 LocalDate orderDate, LocalDate deliveryDate, OrderStatus orderStatus) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.orderProducts = orderProducts;
        this.invoice = invoice;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", customer=" + customer.getId() +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", orderStatus=" + orderStatus.getOrderState() +
                '}' + '\n';
    }
}
