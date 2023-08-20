package com.cprt.store.invoice;

import java.time.LocalDate;

import com.cprt.store.budget.Budget;

public class Invoice {

    private String customerName;
    private LocalDate creationDate;
    private Budget budget;

    public Invoice(String customerName, LocalDate creationDate, Budget budget) {
        this.customerName = customerName;
        this.creationDate = creationDate;
        this.budget = budget;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Budget getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Invoice [customerName=" + customerName + ", creationDate=" + creationDate + ", budget=" + budget + "]";
    }

}
