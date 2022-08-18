package com.example.juiceFactory2_0.adapter;

import com.example.juiceFactory2_0.config.JPAConfiguration;
import com.example.juiceFactory2_0.dao.InvoiceDAO;
import com.example.juiceFactory2_0.entity.Invoice;

import java.text.DecimalFormat;

public class PriceAdapter extends Invoice {
    private Invoice invoice;
    private Double exchangeRate;
    private String orderNumber;
    InvoiceDAO invoiceDAO = new InvoiceDAO(JPAConfiguration.getEntityManager());

    public PriceAdapter(Invoice invoice, Double exchangeRate) {
        this.invoice = invoice;
        this.exchangeRate = exchangeRate;
    }

    public PriceAdapter(String orderNumber, Double exchangeRate) {
        this.orderNumber = orderNumber;
        this.exchangeRate = exchangeRate;
    }

    public void convertPriceToUSD() {
        double newPrice;
        newPrice = invoice.getTotalPrice() / exchangeRate;
        DecimalFormat df = new DecimalFormat(".00");
        df.format(newPrice);
        System.out.println("$"+ df.format(newPrice));
    }

    public void convertToUSD() {
        double exchangedPrice;
        double beforeExchange;
        beforeExchange = invoiceDAO.findByOrderNumber(orderNumber).getTotalPrice();
        exchangedPrice = invoiceDAO.findByOrderNumber(orderNumber).getTotalPrice() / exchangeRate;
        DecimalFormat df = new DecimalFormat(".00");
        df.format(exchangedPrice);
        System.out.println("SRD " + beforeExchange + " with a exchange rate of " + exchangeRate + " is $" +
                            df.format(exchangedPrice));
    }
}
