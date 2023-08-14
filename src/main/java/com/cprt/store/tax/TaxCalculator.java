package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class TaxCalculator {

    public BigDecimal calculate(Budget budget, Tax tax) {
        return tax.calculate(budget);
    }

}
