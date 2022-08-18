package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.PaymentMethodDAO;
import com.example.juiceFactory2_0.entity.PaymentMethod;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/paymentMethod")
public class PaymentMethodResource {
    private final PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentMethod> fetchAll() {
        return paymentMethodDAO.retrievePaymentMethodList();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentMethod add(PaymentMethod paymentMethod) {
        return paymentMethodDAO.insert(paymentMethod);
    }
}
