package com.example.juiceFactory2_0.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private Long customerNumber;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String phoneNumber;
    @Column
    private LocalDate dateRegistered;

    public Customer(Long id, Long customerNumber, String name, String address, String district, String phoneNumber,
                    LocalDate dateRegistered) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.name = name;
        this.address = address;
        this.district = district;
        this.phoneNumber = phoneNumber;
        this.dateRegistered = dateRegistered;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateRegistered=" + dateRegistered +
                '}';
    }
}
