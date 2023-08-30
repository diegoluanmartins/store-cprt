package com.cprt.store.budget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cprt.store.DomainException;
import com.cprt.store.budget.state.BudgetState;
import com.cprt.store.budget.state.Completed;
import com.cprt.store.budget.state.InAnalysis;

public class Budget implements Budgetable {

    private BigDecimal value;
    private BudgetState state;
    private List<Budgetable> items;

    public Budget() {
        this.value = BigDecimal.ZERO;
        this.state = new InAnalysis();
        this.items = new ArrayList<>();
    }

    public Budget(Budgetable budgetItem) {
        this.value = budgetItem.getValue();
        this.state = new InAnalysis();
        this.items = new ArrayList<>();
        this.items.add(budgetItem);
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

    @Override
    public BigDecimal getValue(){
        try {
            Thread.sleep(2000L);
        } catch (final InterruptedException e) {
            throw new DomainException(Arrays.toString(e.getStackTrace()));
        }
        return value;
    }

    public int getQtyOfItem() {
        return this.items.size();
    }

    public void addItem(Budgetable item) {
        this.sumValue(item.getValue());
        this.items.add(item);
    }

    private void sumValue(BigDecimal addValue) {
        this.value = this.value.add(addValue);
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

    @Override
    public String toString() {
        return "Budget [value=" + value + ", state=" + state + ", items=" + items + "]";
    }

}
