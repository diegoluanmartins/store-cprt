package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class TaxISS implements Tax {
    public BigDecimal calculate(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.06"));
    }
}
