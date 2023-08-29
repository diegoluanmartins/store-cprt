package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class TaxISS extends Tax {

    public TaxISS(Tax next) {
        super(next);
    }

    public TaxISS() {
        super(null);
    }

    @Override
    protected BigDecimal executeCalculate(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.06"));
    }
    
}
