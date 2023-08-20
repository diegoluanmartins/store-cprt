package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class WithoutDiscount extends Discount {

    public WithoutDiscount() {
        super(null);
    }

    @Override
    public BigDecimal getDiscount(Budget budget) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean isValid(Budget budget) {
        return true;
    }

}
