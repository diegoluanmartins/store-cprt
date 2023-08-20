package com.cprt.store.invoice;

import java.time.LocalDate;
import java.util.List;

import com.cprt.store.budget.Budget;
import com.cprt.store.invoice.action.InvoiceCreationAction;

public class CreateInvoiceHandler {

    private List<InvoiceCreationAction> actions;
   
    public CreateInvoiceHandler(List<InvoiceCreationAction> actions) {
        this.actions = actions;
    }

    public void execute(CreateInvoice invoiceData) {
        Budget budget = new Budget(invoiceData.getBudgetValue(), invoiceData.getQtyOfItem());
        LocalDate creationDate = LocalDate.now();
        Invoice invoice = new Invoice(invoiceData.getCustomerName(), creationDate, budget);
        actions.forEach(action -> action.execute(invoice));
    }

}
