package com.cprt.store.budget;

import java.math.BigDecimal;

public class Budget {
    
    private BigDecimal value;
    private int qty;

    public Budget(BigDecimal value, int qty) {
        this.value = value;
        this.qty = qty;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Budget [value=" + value + ", qty=" + qty + "]";
    }

}
