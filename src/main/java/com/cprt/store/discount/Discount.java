package com.cprt.store.discount;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public abstract class Discount {

    protected Discount next;

    protected Discount(Discount next) {
        this.next = next;
    }

    public BigDecimal calculate(Budget budget){
        if(isValid(budget)){
            return getDiscount(budget);
        }
        return next.calculate(budget);
    }

    protected abstract BigDecimal getDiscount(Budget budget);
    protected abstract boolean isValid(Budget budget);

}
