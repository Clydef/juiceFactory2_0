package com.example.juiceFactory2_0.adapter;

import java.text.DecimalFormat;

public class LocalForeignAdapterImpl implements LocalForeignAdapter {
//    private Invoice invoice;
    private ForeignCurrency foreignCurrency;

    /*public LocalForeignAdapterImpl(Invoice invoice) {
        this.invoice = invoice;
    }*/

    /*@Override
    public ForeignCurrency convertPriceToUSD(Double exchangeRate) {
        double newPrice;
        newPrice = invoice.getTotalPrice() / exchangeRate;
        DecimalFormat df = new DecimalFormat(".00");
        df.format(newPrice);
        foreignCurrency.setTotalPriceInUSD(newPrice);
        return foreignCurrency;
    }*/

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
