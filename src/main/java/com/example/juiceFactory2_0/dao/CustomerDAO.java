package com.example.juiceFactory2_0.dao;

import com.example.juiceFactory2_0.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerDAO {
    private EntityManager entityManager;

    public CustomerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Customer> retrieveCustomerList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        List<Customer> customerList = query.getResultList();
        entityManager.getTransaction().commit();
        return customerList;
    }

    public Customer findByCustomerNumber(Long customerNumber) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c  where c.customerNumber = :customerNumber";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        Customer customer = query.setParameter("customerNumber", customerNumber).getSingleResult();
        entityManager.getTransaction().commit();
        return customer;
    }

    public Customer insert(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    public int updateCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Customer c SET c.address = :address where c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customer.getCustomerNumber());
        query.setParameter("address", customer.getAddress());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int delete(Long customerNumber) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Customer c where c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }
}
