package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class DiscountBudgetAboveValue extends Discount {

    private static final BigDecimal MINIMUM_VAL = new BigDecimal("500");
    private static final BigDecimal PERCENTAGE = new BigDecimal("0.05");

    public DiscountBudgetAboveValue(Discount next) {
        super(next);
    }

    @Override
    public BigDecimal getDiscount(Budget budget) {
        return budget.getValue().multiply(PERCENTAGE);
    }

    @Override
    public boolean isValid(Budget budget) {
        return (budget.getValue().compareTo(MINIMUM_VAL) > 0);
    }

    
}
