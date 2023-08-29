package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public abstract class Tax {
    
    private Tax next;

    public Tax(Tax next) {
        this.next = next;
    }

    protected abstract BigDecimal executeCalculate(Budget budget);
    
    public BigDecimal calculate(Budget budget){
        BigDecimal taxValue = executeCalculate(budget);
        BigDecimal nextTaxValue = BigDecimal.ZERO;
        if(next != null){
            nextTaxValue = next.executeCalculate(budget);
        }
        return taxValue.add(nextTaxValue);
    }

}
