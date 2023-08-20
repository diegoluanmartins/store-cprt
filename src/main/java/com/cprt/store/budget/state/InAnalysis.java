package com.cprt.store.budget.state;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class InAnalysis extends BudgetState{
    
    @Override
    public BigDecimal calculateExtraDiscountValue(Budget budget){
        return budget.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void approve(Budget budget){
        budget.setState(new Approved());
    }

    @Override
    public void reprove(Budget budget){
        budget.setState(new Reprove());
    }
}
