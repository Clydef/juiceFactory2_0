package com.example.juiceFactory2_0.adapter;
import com.example.juiceFactory2_0.entity.Invoice;

import java.text.DecimalFormat;

public class LocalForeignAdapter implements LocaltoUSDAdapter {
    private Invoice invoice;

    public LocalForeignAdapter(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public Invoice convertPriceToUSD(Double exchangeRate) {
        double newPrice;
        newPrice = invoice.getTotalPrice() / exchangeRate;
        DecimalFormat df = new DecimalFormat(".00");
        df.format(newPrice);
        invoice.setTotalPrice(newPrice);
        return invoice;
    }

    /*public void convertToUSD() {
        double exchangedPrice;
        double beforeExchange;
        beforeExchange = invoiceDAO.findByOrderNumber(orderNumber).getTotalPrice();
        exchangedPrice = invoiceDAO.findByOrderNumber(orderNumber).getTotalPrice() / exchangeRate;
        DecimalFormat df = new DecimalFormat(".00");
        df.format(exchangedPrice);
        System.out.println("SRD " + beforeExchange + " with a exchange rate of " + exchangeRate + " is $" +
                            df.format(exchangedPrice));
    }*/
}
