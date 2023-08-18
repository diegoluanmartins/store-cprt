package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class DiscountBudgetAboveValue extends Discount {

    private static final BigDecimal MINIMUM_VAL = new BigDecimal("500");

    public DiscountBudgetAboveValue(Discount next) {
        super(next);
    }

    public BigDecimal calculate(Budget budget) {
        final BigDecimal discountPercentage = new BigDecimal("0.05");
        if (budget.getValue().compareTo(MINIMUM_VAL) > 0) {
            return budget.getValue().multiply(discountPercentage);
        }
        return next.calculate(budget);
    }
}
