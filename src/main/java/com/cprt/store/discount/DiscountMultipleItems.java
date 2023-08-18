package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class DiscountMultipleItems extends Discount {

    public DiscountMultipleItems(Discount next) {
        super(next);
    }

    private static final int MINIMUM_QTY = 5;

    public BigDecimal calculate(Budget budget) {
        final BigDecimal discountPercentage = new BigDecimal("0.1");
        if (budget.getQty() > MINIMUM_QTY) {
            return budget.getValue().multiply(discountPercentage);
        }
        return next.calculate(budget);
    }
}
