package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class TaxCalculator {

    public BigDecimal calculate(Budget budget, TaxType type){
        switch (type) {
            case ICMS:
                return budget.getValue().multiply(new BigDecimal("0.1"));
            case ISS:
                return budget.getValue().multiply(new BigDecimal("0.6"));
            default:
                return BigDecimal.ZERO;
        }
        
    }

}
