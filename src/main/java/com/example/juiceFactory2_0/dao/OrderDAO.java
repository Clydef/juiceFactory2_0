package com.example.juiceFactory2_0.dao;


import com.example.juiceFactory2_0.entity.Order;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class OrderDAO {
    private EntityManager entityManager;

    public OrderDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Order> retrieveOrderList() {
        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        String jpql = "select c from Order c";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        List<Order> orderList = query.getResultList();
        entityManager.getTransaction().commit();
        return orderList;
    }

    public List<Order> findOrderDateByQuarter(LocalDate orderDate) {
        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        String jpql = "select c from Order c where QUARTER(c.orderDate) =:quarter";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        List<Order> orderList = query.setParameter("quarter", 1).getResultList();
        entityManager.getTransaction().commit();
        return orderList;
    }

    public List<Object[]> findOrderDateByMonth(int year) {
            if(!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
        TypedQuery<Object[]> query = entityManager.createQuery("SELECT o, c FROM Order o JOIN o.customer c WHERE YEAR(o.orderDate) = :year", Object[].class);
        query.setParameter("year", year);
        List<Object[]> orders = query.getResultList();
            entityManager.getTransaction().commit();
            System.out.println(orders);
            return orders;
    }

    public Order mostFrequentCustomer() {
        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        String jpql = "select o from Order o join o.customer c group by c.id order by count(c), c.id";
//        String jpql = "SELECT o FROM Order o LEFT JOIN o.customer c GROUP BY c.id ORDER BY COUNT(c), c.id";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        List<Order> order = query.getResultList();
        if(order.size() == 0) {return null;}
        Order order1 = order.get(order.size()-1);
        entityManager.getTransaction().commit();
        return order1;
    }

    public Order findByOrderNumber(String orderNumber) {
        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        String jpql = "select c from Order c  where c.orderNumber = :orderNumber";
        TypedQuery<Order> query = entityManager.createQuery(jpql, Order.class);
        Order order = query.setParameter("orderNumber", orderNumber).getSingleResult();
        entityManager.getTransaction().commit();
        return order;
    }

    public Order insert(Order order) {
        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        entityManager.persist(order);
        entityManager.getTransaction().commit();
        return order;
    }

    public int updateOrder(Order order) {
        /*entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Order c SET c.deliveryDate = :deliveryDate where c.orderNumber = :orderNumber");
        query.setParameter("orderNumber", order.getOrderNumber());
        query.setParameter("deliveryDate", order.getDeliveryDate());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;*/
        return 0;
    }

    public int delete(String orderNumber) {
        if(!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
        Query query = entityManager.createQuery("delete from Order c where c.orderNumber = :orderNumber");
        query.setParameter("orderNumber", orderNumber);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
