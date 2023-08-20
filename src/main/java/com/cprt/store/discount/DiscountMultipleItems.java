package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class DiscountMultipleItems extends Discount {

    private static final int MINIMUM_QTY = 5;
    private static final BigDecimal PERCENTAGE = new BigDecimal("0.1");

    public DiscountMultipleItems(Discount next) {
        super(next);
    }

    @Override
    public BigDecimal getDiscount(Budget budget) {
        return budget.getValue().multiply(PERCENTAGE);
    }

    @Override
    public boolean isValid(Budget budget) {
        return (budget.getQtyOfItem() > MINIMUM_QTY);
    }

    
}
