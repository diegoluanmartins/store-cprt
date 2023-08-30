package com.cprt.store.budget.state;

import java.math.BigDecimal;

import com.cprt.store.DomainException;
import com.cprt.store.budget.Budget;

public abstract class BudgetState {

    private String getExceptionMessage(String invalidAction) {
        return "Budget cannot execute " + invalidAction;
    }

    public BigDecimal calculateExtraDiscountValue(Budget budget){
        return BigDecimal.ZERO;
    }

    public void approve(Budget budget){
        throw new DomainException(getExceptionMessage(this.getClass().getEnclosingMethod().getName()));
    }

    public void reprove(Budget budget){
        throw new DomainException(getExceptionMessage(this.getClass().getEnclosingMethod().getName()));
    }

    public void complete(Budget budget){
        throw new DomainException(getExceptionMessage(this.getClass().getEnclosingMethod().getName()));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
}
