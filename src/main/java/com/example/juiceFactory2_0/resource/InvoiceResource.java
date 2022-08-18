package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.InvoiceDAO;
import com.example.juiceFactory2_0.entity.Invoice;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/invoice")
public class InvoiceResource {
    private final InvoiceDAO invoiceDAO = new InvoiceDAO(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Invoice> fetchAll() {
        return invoiceDAO.retrieveInvoiceList();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Invoice add(Invoice invoice) {
        return invoiceDAO.insert(invoice);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int update(Invoice customer) {
        return invoiceDAO.updateInvoice(customer);
    }

    @Path("/getInvoice")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Invoice getInvoice(String orderNumber) {
        return invoiceDAO.findByOrderNumber(orderNumber);
    }
}
