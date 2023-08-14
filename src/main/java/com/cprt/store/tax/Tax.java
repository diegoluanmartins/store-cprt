package com.cprt.store.tax;

import java.math.BigDecimal;

import com.cprt.store.budget.Budget;

public interface Tax {
    public BigDecimal calculate(Budget budget);
}
