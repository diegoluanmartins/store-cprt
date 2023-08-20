package com.cprt.store.invoice;

import java.math.BigDecimal;

public class CreateInvoice {

    private String customerName;
    private BigDecimal budgetValue;
    private int qtyOfItem;

    public CreateInvoice(String customerName, BigDecimal budgetValue, int qtyOfItem) {
        this.customerName = customerName;
        this.budgetValue = budgetValue;
        this.qtyOfItem = qtyOfItem;
    }

    public String getCustomerName() {
        return customerName;
    }

    public BigDecimal getBudgetValue() {
        return budgetValue;
    }

    public int getQtyOfItem() {
        return qtyOfItem;
    }

}
