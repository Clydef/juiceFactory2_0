package com.example.juiceFactory2_0.dao;

import com.example.juiceFactory2_0.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

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

    public Customer findByCustomerNumber(String customerNumber) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Customer c where c.customerNumber = :customerNumber";
        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        Customer customer = null;
        try {
            customer = query.setParameter("customerNumber", customerNumber).getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Geen user met aangegeven customernumber");
        }
        entityManager.getTransaction().commit();
        return customer;
    }

    public Customer insert(Customer customer) {
        customer.setDateRegistered(LocalDate.now());
        customer.setCustomerNumber(generateCustomerNumber());
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return customer;
    }

    public int updateCustomer(Customer customer) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Customer c SET c.address = :address, c.firstName = :firstName," +
                "c.lastName = :lastName, c.category = :category, c.email = :email, c.district = :district, c.phoneNumber = :phoneNumber where c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customer.getCustomerNumber());
        query.setParameter("address", customer.getAddress());
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("district", customer.getDistrict());
        query.setParameter("phoneNumber", customer.getPhoneNumber());
        query.setParameter("lastName", customer.getLastName());
        query.setParameter("email", customer.getEmail());
        query.setParameter("category", customer.getCategory());
        int rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

    public int delete(String customerNumber) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("delete from Customer c where c.customerNumber = :customerNumber");
        query.setParameter("customerNumber", customerNumber);
        int rowsDeleted = query.executeUpdate();
        System.out.println("entities deleted: " + rowsDeleted);
        entityManager.getTransaction().commit();
        return rowsDeleted;
    }

    public static String generateCustomerNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("TS");
        for (int i = 0; i < 5; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
