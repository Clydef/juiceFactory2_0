package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.CustomerDAO;
import com.example.juiceFactory2_0.entity.Customer;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


import java.util.List;

@Path("customer")
public class CustomerResource {
    private final CustomerDAO customerDAO = new CustomerDAO(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> fetchAll() {
        return customerDAO.retrieveCustomerList();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer add(Customer customer) {
        System.out.println(customer);
        return customerDAO.insert(customer);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int update(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int remove(Long customerNumber) { return customerDAO.delete(customerNumber); }

    @Path("/getCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getBook(Object customerNumber) {
        return customerDAO.findByCustomerNumber(customerNumber);
    }

}

