package com.cprt.store.budget.state;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public class Approved extends BudgetState {

    @Override
    public BigDecimal calculateExtraDiscountValue(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void reprove(Budget budget) {
        budget.setState(new Reproved());
    }

    @Override
    public void complete(Budget budget) {
        budget.setState(new Completed());
    }

}
