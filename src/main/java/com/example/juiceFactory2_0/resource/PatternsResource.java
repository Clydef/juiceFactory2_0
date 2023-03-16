package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.adapter.SRD;
import com.example.juiceFactory2_0.adapter.SRDUSDConverter;
import com.example.juiceFactory2_0.adapter.USD;
import com.example.juiceFactory2_0.adapter.USDSRDConverter;
import com.example.juiceFactory2_0.entity.PaymentMethod;

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
}
