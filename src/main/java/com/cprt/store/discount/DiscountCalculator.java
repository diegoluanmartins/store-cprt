package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class DiscountCalculator {

    public BigDecimal calculate(Budget budget){
        BigDecimal discountPercentage = (budget.getQty() > 5) ? new BigDecimal("0.10") : new BigDecimal("0");
        if (budget.getValue().compareTo(new BigDecimal("500")) > 0) discountPercentage = new BigDecimal("0.10");
        return budget.getValue().multiply(discountPercentage);
    }

}
