package com.example.juiceFactory2_0.dao;


import com.example.juiceFactory2_0.entity.OrderStatus;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class OrderStatusDAO {
    private EntityManager entityManager;

    public OrderStatusDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<OrderStatus> retrieveOrderStatusList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from OrderStatus c";
        TypedQuery<OrderStatus> query = entityManager.createQuery(jpql, OrderStatus.class);
        List<OrderStatus> orderStatusList = query.getResultList();
        entityManager.getTransaction().commit();
        return orderStatusList;
    }

    public OrderStatus findOrderStatusByOrderNumber(String order) {
        entityManager.getTransaction().begin();
        String jpql = "select c from OrderStatus c  where c.order = :order";
        TypedQuery<OrderStatus> query = entityManager.createQuery(jpql, OrderStatus.class);
        OrderStatus orderStatus = query.setParameter("order", order).getSingleResult();
        entityManager.getTransaction().commit();
        return orderStatus;
    }

    public OrderStatus insert(OrderStatus orderStatus) {
        entityManager.getTransaction().begin();
        entityManager.persist(orderStatus);
        entityManager.getTransaction().commit();
        return orderStatus;
    }

    public int updateOrderStatus(OrderStatus orderStatus) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE OrderStatus c SET c.orderState = :orderState where c.order = :order");
        query.setParameter("order", orderStatus.getOrder());
        query.setParameter("orderState", orderStatus.getOrderState());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }
}
