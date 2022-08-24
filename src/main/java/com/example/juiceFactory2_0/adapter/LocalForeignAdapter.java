package com.example.juiceFactory2_0.adapter;

import com.example.juiceFactory2_0.entity.Invoice;

public interface LocalForeignAdapter {
    ForeignCurrency convertPriceToUSD(Double exchangeRate);
}
