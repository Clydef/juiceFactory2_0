package com.example.juiceFactory2_0.resource;

import com.example.juiceFactory2_0.adapter.SRD;
import com.example.juiceFactory2_0.adapter.SRDUSDConverter;
import com.example.juiceFactory2_0.adapter.USD;
import com.example.juiceFactory2_0.adapter.USDSRDConverter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;

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
}
