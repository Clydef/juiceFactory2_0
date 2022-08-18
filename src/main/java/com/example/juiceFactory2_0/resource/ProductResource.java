package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.ProductDAO;
import com.example.juiceFactory2_0.entity.Product;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("product")
public class ProductResource {

    private final ProductDAO productDAO = new ProductDAO(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> fetchAll() {
        return productDAO.retrieveProductList();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product add(Product product) {
        return productDAO.insert(product);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int update(Product product) {
        return productDAO.updateProduct(product);
    }

//    @Path("/remove")
//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public int remove(Long customerNumber) { return productDAO.(customerNumber); }

    @Path("/getProduct")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(String productCode) { return productDAO.findProductByProductCode(productCode); }

}
