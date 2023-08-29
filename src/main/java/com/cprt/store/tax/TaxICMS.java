package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class TaxICMS extends Tax{

    public TaxICMS(Tax next) {
        super(next);
    }

    public TaxICMS() {
        super(null);
    }

    @Override
    protected BigDecimal executeCalculate(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.1"));
    }
    
}
