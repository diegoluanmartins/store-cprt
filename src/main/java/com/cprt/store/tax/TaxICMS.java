package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class TaxICMS implements Tax{
    public BigDecimal calculate(Budget budget){
        return budget.getValue().multiply(new BigDecimal("0.1"));
    }
}
