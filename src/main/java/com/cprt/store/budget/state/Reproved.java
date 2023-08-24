package com.cprt.store.budget.state;

import com.cprt.store.budget.Budget;

public class Reproved extends BudgetState {

    @Override
    public void complete(Budget budget) {
        budget.setState(new Completed());
    }

}
