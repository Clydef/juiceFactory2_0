package com.example.juiceFactory2_0.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class OrderCountByYear {
    long count;
    LocalDate localDate;

    public OrderCountByYear(long count, LocalDate localDate) {
        this.count = count;
        this.localDate = localDate;
    }

    public OrderCountByYear() {
    }

    @Override
    public String toString() {
        return "OrderCountByYear{" +
                "count=" + count +
                ", localDate=" + localDate +
                '}';
    }
}
