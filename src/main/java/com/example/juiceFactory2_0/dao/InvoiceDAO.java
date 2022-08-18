package com.example.juiceFactory2_0.dao;


import com.example.juiceFactory2_0.entity.Invoice;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class InvoiceDAO {
    private EntityManager entityManager;

    public InvoiceDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Invoice> retrieveInvoiceList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Invoice c";
        TypedQuery<Invoice> query = entityManager.createQuery(jpql, Invoice.class);
        List<Invoice> invoiceList = query.getResultList();
        entityManager.getTransaction().commit();
        return invoiceList;
    }

    public Invoice findByOrderNumber(String orderNumber) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Invoice c  where c.order.orderNumber = :orderNumber";
        TypedQuery<Invoice> query = entityManager.createQuery(jpql, Invoice.class);
        Invoice invoice = query.setParameter("orderNumber", orderNumber).getSingleResult();
        entityManager.getTransaction().commit();
        return invoice;
    }

//    public Invoice getmost(String orderNumber) {
//        entityManager.getTransaction().begin();
//        String jpql = "select c from Invoice c  where c.totalPrice>500 = :orderNumber";
//        TypedQuery<Invoice> query = entityManager.createQuery(jpql, Invoice.class);
//        Invoice invoice = query.setParameter("orderNumber", orderNumber).getSingleResult();
//        entityManager.getTransaction().commit();
//        return invoice;
//    }

    public Invoice insert(Invoice invoice) {
        entityManager.getTransaction().begin();
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();
        return invoice;
    }

    public int updateInvoice(Invoice invoice) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Invoice c SET c.totalPrice = :totalPrice where c.order.orderNumber = :orderNumber");
        query.setParameter("orderNumber", invoice.getOrder().getOrderNumber());
        query.setParameter("totalPrice", invoice.getTotalPrice());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;
    }

//    public int delete(String Number) {
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("delete from Customer c where c.customerNumber = :customerNumber");
//        query.setParameter("customerNumber", customerNumber);
//        int rowsDeleted = query.executeUpdate();
//        System.out.println("entities deleted: " + rowsDeleted);
//        entityManager.getTransaction().commit();
//        return rowsDeleted;

}
