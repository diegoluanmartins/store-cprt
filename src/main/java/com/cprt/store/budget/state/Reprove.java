package com.cprt.store.budget.state;

import com.cprt.store.budget.Budget;

public class Reprove extends BudgetState {

    @Override
    public void complete(Budget budget) {
        budget.setState(new Completed());
    }

}
