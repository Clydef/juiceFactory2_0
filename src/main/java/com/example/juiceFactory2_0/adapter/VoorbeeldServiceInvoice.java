package com.example.juiceFactory2_0.adapter;

import com.example.juiceFactory2_0.entity.Invoice;

public class VoorbeeldServiceInvoice {

    public ForeignCurrency getUSD(Invoice invoice){
        Double exchangeRate = 22.56;
        LocalForeignAdapter localForeignAdapter = new LocalForeignAdapterImpl(invoice);
        return localForeignAdapter.convertPriceToUSD(exchangeRate);
    }
}
