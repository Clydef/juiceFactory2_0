package com.example.juiceFactory2_0.dao;

import com.example.juiceFactory2_0.entity.PaymentMethod;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PaymentMethodDAO {
    private EntityManager entityManager;

    public PaymentMethodDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<PaymentMethod> retrievePaymentMethodList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from PaymentMethod c";
        TypedQuery<PaymentMethod> query = entityManager.createQuery(jpql, PaymentMethod.class);
        List<PaymentMethod> paymentMethodList = query.getResultList();
        entityManager.getTransaction().commit();
        return paymentMethodList;
    }

    public PaymentMethod insert(PaymentMethod paymentMethod) {
        entityManager.getTransaction().begin();
        entityManager.persist(paymentMethod);
        entityManager.getTransaction().commit();
        return paymentMethod;
    }

//    public int delete(String paymentMethod) {
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("delete from Customer c where c.customerNumber = :customerNumber");
//        query.setParameter("customerNumber", customerNumber);
//        int rowsDeleted = query.executeUpdate();
//        System.out.println("entities deleted: " + rowsDeleted);
//        entityManager.getTransaction().commit();
//        return rowsDeleted;
//    }
}
