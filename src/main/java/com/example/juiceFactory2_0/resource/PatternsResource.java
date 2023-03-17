package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.adapter.SRD;
import com.example.juiceFactory2_0.adapter.SRDUSDConverter;
import com.example.juiceFactory2_0.adapter.USD;
import com.example.juiceFactory2_0.adapter.USDSRDConverter;
import com.example.juiceFactory2_0.entity.Customer;
import com.example.juiceFactory2_0.entity.PaymentMethod;
import com.example.juiceFactory2_0.service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("pattern")
public class PatternsResource {

    @Path("/SRDConverter")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal SRDConverter(String amount) {
        SRDUSDConverter srdusdConverter = new SRDUSDConverter(new BigDecimal("34.50"));
        SRD srd = new SRD(new BigDecimal(amount));
        return srdusdConverter.convert(srd).getAmount();
    }

    @Path("/USDConverter")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BigDecimal currencyConverter(String amount) {
        USDSRDConverter usdsrdConverter = new USDSRDConverter(new BigDecimal("34.50"));
        USD usd = new USD(new BigDecimal(amount));
        return usdsrdConverter.convert(usd).getAmount();
    }

    @Path("/paymentMethods")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentMethod> paymentMethods() {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethods.add(PaymentMethod.BANK);
        paymentMethods.add(PaymentMethod.CASH);
        paymentMethods.add(PaymentMethod.UNI5PAY);
        paymentMethods.add(PaymentMethod.MOPÉ);
        return paymentMethods;
    }

    @Path("/transport")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String transport(Customer customer) {
        TransportFactory factory = new TransportFactory();
        Transport transport = factory.getInstance(customer);
        String customerName = customer.getFirstName();
        String paymentMethod = payment(customer.getCategory());
        String transportMethod = transport.deliver();
        return orderMessage(customerName, paymentMethod, transportMethod);
    }

    public String payment(String paymentMethod) {
        PaymentStrategy paymentStrategy;
        switch (paymentMethod) {
            case "CASH":
                paymentStrategy = new CashStrategy();
                break;
            case "BANK":
                paymentStrategy = new BankStrategy();
                break;
            case "MOPÉ":
                paymentStrategy = new MopeStrategy();
                break;
            case "UNI5PAY":
                paymentStrategy = new Uni5payStrategy();
                break;
            default:
                paymentStrategy = null;
                break;
        }
        PaymentContext paymentContext = new PaymentContext(paymentStrategy);

        return paymentContext.usePaymentMethod(new BigDecimal("0"));
    }

    public String orderMessage(String customerName, String paymentMethod, String transportMethod) {
        return "Dear " + customerName + ", the order will be " + paymentMethod + " and " + transportMethod;
    }
}
