package com.example.juiceFactory2_0.dao;

import com.example.juiceFactory2_0.entity.OrderProducts;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderProductDAO {
    private EntityManager entityManager;
    public OrderProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public OrderProducts mostFrequentBoughtProduct() {
        entityManager.getTransaction().begin();
        String jpql = "select c from OrderProducts c join c.product p group by p.id order by count(p), p.id";
        TypedQuery<OrderProducts> query = entityManager.createQuery(jpql, OrderProducts.class);
        List<OrderProducts> orderProductsList = query.getResultList();
        OrderProducts products = orderProductsList.get(orderProductsList.size()-1);
        entityManager.getTransaction().commit();
        return products;
    }
}
