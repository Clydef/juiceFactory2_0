package com.example.juiceFactory2_0.dao;

import com.example.juiceFactory2_0.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAO {
    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> retrieveProductList() {
        entityManager.getTransaction().begin();
        String jpql = "select c from Product c";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        List<Product> productList = query.getResultList();
        entityManager.getTransaction().commit();
        return productList;
    }

    public Product findProductByProductCode(String code) {
        entityManager.getTransaction().begin();
        String jpql = "select c from Product c  where c.code = :code";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        Product product = query.setParameter("code", code).getSingleResult();
        entityManager.getTransaction().commit();
        return product;
    }

    public Product insert(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    public int updateProduct(Product product) {
        /*entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Product c SET c.productDescription = :productDescription where c.productCode = :productCode");
        query.setParameter("productCode", product.getProductDescription());
        query.setParameter("productDescription", product.getProductDescription());
        int rowsUpdated = query.executeUpdate();
        System.out.println("entities Updated: " + rowsUpdated);
        entityManager.getTransaction().commit();
        return rowsUpdated;*/
        return 0;
    }
}
