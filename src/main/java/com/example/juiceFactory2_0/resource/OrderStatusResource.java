package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.OrderStatusDAO;
import com.example.juiceFactory2_0.entity.OrderStatus;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/orderStatus")
public class OrderStatusResource {
    private final OrderStatusDAO orderStatusDAO = new OrderStatusDAO(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderStatus> fetchAll() { return orderStatusDAO.retrieveOrderStatusList(); }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderStatus add(OrderStatus orderStatus) {
        return orderStatusDAO.insert(orderStatus);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int update(OrderStatus orderStatus) {
        return orderStatusDAO.updateOrderStatus(orderStatus);
    }

    @Path("/getCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public OrderStatus getOrderStatus(String orderNumber) {
        return orderStatusDAO.findOrderStatusByOrderNumber(orderNumber); }
}
