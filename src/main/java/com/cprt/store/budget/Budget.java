package com.cprt.store.budget;

import java.math.BigDecimal;

import com.cprt.store.budget.state.BudgetState;
import com.cprt.store.budget.state.Completed;
import com.cprt.store.budget.state.InAnalysis;

public class Budget {

    private BigDecimal value;
    private int qtyOfItem;
    private BudgetState state;

    public Budget(BigDecimal value, int qtyOfItem) {
        this.value = value;
        this.qtyOfItem = qtyOfItem;
        this.state = new InAnalysis();
    }

    public void applyExtraDiscount() {
        BigDecimal extraDiscount = this.state.calculateExtraDiscountValue(this);
        this.value = this.value.subtract(extraDiscount);
    }

    public void approve() {
        this.state.approve(this);
    }

    public void reprove() {
        this.state.reprove(this);
    }

    public void complete() {
        this.state.complete(this);
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getQtyOfItem() {
        return qtyOfItem;
    }

    public void setQtyOfItem(int qty) {
        this.qtyOfItem = qty;
    }

    @Override
    public String toString() {
        return "Budget [value=" + value + ", qty=" + qtyOfItem +  ", state=" + state.getClass().getName() + "]";
    }

    public BudgetState getState() {
        return state;
    }

    public void setState(BudgetState state) {
        this.state = state;
    }

    public boolean isCompleted() {
        return this.state instanceof Completed;
    }

}
