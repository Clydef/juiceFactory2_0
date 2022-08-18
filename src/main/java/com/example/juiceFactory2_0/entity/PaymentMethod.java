package com.example.juiceFactory2_0.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "invoice_method")
    private Set<Invoice> invoices;
    @Column
    private String paymentMethodName;

    public PaymentMethod(Long id, Set<Invoice> invoices, String paymentMethodName) {
        this.id = id;
        this.invoices = invoices;
        this.paymentMethodName = paymentMethodName;
    }

    public PaymentMethod() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", invoices=" + invoices +
                ", paymentMethodName='" + paymentMethodName + '\'' +
                '}';
    }
}
