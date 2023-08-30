package com.cprt.store.budget;

import java.math.BigDecimal;

public class BudgetProxy implements Budgetable {

    private BigDecimal value;
    private Budgetable budget;

    public BudgetProxy(Budgetable budget) {
        this.budget = budget;
    }

    @Override
    public BigDecimal getValue() {
        if(this.value == null){ 
            this.value = budget.getValue();
        }
        return this.value;
    }

}
