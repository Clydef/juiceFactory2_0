package com.example.juiceFactory2_0.adapter;

import com.example.juiceFactory2_0.entity.Invoice;

public class VoorbeeldServiceInvoice {

    public Invoice getUSD(Invoice invoice){
        Double exchangeRate = 22.56;
        LocaltoUSDAdapter localtoUSDAdapter = new LocalForeignAdapter(invoice);
        return localtoUSDAdapter.convertPriceToUSD(exchangeRate);
    }
}
