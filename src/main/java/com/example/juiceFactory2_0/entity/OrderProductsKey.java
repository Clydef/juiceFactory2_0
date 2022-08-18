package com.example.juiceFactory2_0.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class OrderProductsKey implements Serializable {

    @Column
    private Long orderId;
    @Column
    private Long productId;

    public OrderProductsKey(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public OrderProductsKey() {

    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


}
