package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.OrderDAO;
import com.example.juiceFactory2_0.entity.Order;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
public class OrderResource {
    private final OrderDAO orderDAO = new OrderDAO(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> fetchAll() {
        return orderDAO.retrieveOrderList();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order add(Order order) {
        return orderDAO.insert(order);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int update(Order order) {
        return orderDAO.updateOrder(order);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int remove(String orderNumber) { return orderDAO.delete(orderNumber); }

    @Path("/getOrder")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(String orderNumber) {
        return orderDAO.findByOrderNumber(orderNumber);
    }
}
