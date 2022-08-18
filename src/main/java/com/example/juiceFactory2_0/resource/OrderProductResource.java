package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.OrderProductDAO;
import com.example.juiceFactory2_0.entity.OrderProducts;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;


@Path("orderProduct")
public class OrderProductResource {
    private final OrderProductDAO orderProductDAO = new OrderProductDAO(JPAConfiguration.getEntityManager());

    @Path("/mostFrequentBoughtProduct")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public OrderProducts mostFrequentBoughtProduct() {
        return orderProductDAO.mostFrequentBoughtProduct();
    }
}
