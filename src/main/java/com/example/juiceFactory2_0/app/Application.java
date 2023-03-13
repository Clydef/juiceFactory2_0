package com.example.juiceFactory2_0.app;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(new Date()));
        System.out.println(LocalDate.now());
        int min = 2000; // Minimum value of range
        int max = 9999; // Maximum value of range
        // Print the min and max
        System.out.println("Random value in int from "+ min + " to " + max + ":");
        // Generate random int value from min to max
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        // Printing the generated random numbers
        System.out.println(random_int);*/
//        JPAConfiguration.getEntityManager();

//        OrderStatus processingStatus = new OrderStatus();
//        processingStatus.setOrderState("Processing");

//        PaymentMethod paymentMethod1 = new PaymentMethod();
//        paymentMethod1.setPaymentMethodName("Mobile Banking");

//        PriceAdapter priceAdapter1 = new PriceAdapter("TS002", 20.75);
//        priceAdapter1.convertToUSD();

        /*TransportFactory tpf = new TransportFactory();

        Transport tp = tpf.getInstance(customerDAO.findByCustomerNumber(6001L));
        System.out.println(tp.deliver());

        CashStrategy cs = new CashStrategy();
        cs.pay(invoiceDAO.findByOrderNumber("TS002"));
        System.out.println(cs);*/
        JPAConfiguration.shutdown();
    }

}
