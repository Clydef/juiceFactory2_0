package com.example.juiceFactory2_0.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_products")
public class OrderProducts {
    @EmbeddedId
    private OrderProductsKey id;
    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;
    @Column
    private Long quantity;

    public OrderProducts(OrderProductsKey id, Order order, Product product, Long quantity) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderProducts() {

    }

    public OrderProductsKey getId() {
        return id;
    }

    public void setId(OrderProductsKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProducts{" +
                "product=" + product +
//                ", quantity=" + quantity +
                '}' + '\n';
    }
}
