package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class DiscountCalculator {

    public BigDecimal calculate(Budget budget) {
        Discount discount = new DiscountMultipleItems(
                new DiscountBudgetAboveValue(new WithoutDiscount()));
        return discount.calculate(budget);
    }

}
