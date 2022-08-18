package com.example.juiceFactory2_0.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @OneToOne(mappedBy = "invoice")
    private Order order;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "invoice_payment_method",
    joinColumns = {@JoinColumn(name = "invoice_id")},
    inverseJoinColumns = {@JoinColumn(name = "payment_method_id")})
    private Set<PaymentMethod> invoice_method;
    @Column
    private Double totalPrice;

    public Invoice(Long id, Order order, Set<PaymentMethod> invoice_method, Double totalPrice) {
        this.id = id;
        this.order = order;
        this.invoice_method = invoice_method;
        this.totalPrice = totalPrice;
    }

    public Invoice() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<PaymentMethod> getInvoice_method() {
        return invoice_method;
    }

    public void setInvoice_method(Set<PaymentMethod> invoice_method) {
        this.invoice_method = invoice_method;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", order=" + order.getOrderNumber() +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
