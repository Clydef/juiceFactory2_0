package com.example.juiceFactory2_0.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@JsonIgnoreProperties("orderProducts")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column(nullable = false, unique = true)
    private String productCode;
    @OneToMany(mappedBy = "product")
    private Set<OrderProducts> orderProducts;
    @Column(nullable = false)
    private String productName;
    @Column
    private String productDescription;
    @Column
    private LocalDate productionDate;
    @Column
    private LocalDate expireDate;
    @Column
    private String typeOfProduct; //sap of vrucht

    public Product(Long id, String productCode, Set<OrderProducts> orderProducts, String productName,
                   String productDescription, LocalDate productionDate, LocalDate expireDate, String typeOfProduct) {
        this.id = id;
        this.productCode = productCode;
        this.orderProducts = orderProducts;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productionDate = productionDate;
        this.expireDate = expireDate;
        this.typeOfProduct = typeOfProduct;
    }

    public Product() {

    }

    public Product(Long id, String productName, String productDescription) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Set<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productionDate=" + productionDate +
                ", expireDate=" + expireDate +
                ", typeOfProduct='" + typeOfProduct + '\'' +
                '}';
    }
}
