package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public abstract class Discount {

    protected Discount next;

    protected Discount(Discount next) {
        this.next = next;
    }

    public abstract BigDecimal calculate(Budget budget);

}
