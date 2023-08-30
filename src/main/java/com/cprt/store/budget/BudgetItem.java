package com.cprt.store.budget;

import java.math.BigDecimal;

public class BudgetItem implements Budgetable {

    private BigDecimal value;

    public BudgetItem(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "BudgetItem [value=" + value + "]";
    }

}
