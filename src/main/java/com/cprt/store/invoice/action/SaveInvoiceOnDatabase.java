package com.cprt.store.invoice.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.cprt.store.invoice.Invoice;

public class SaveInvoiceOnDatabase implements InvoiceCreationAction {

    public void execute(Invoice invoice) {
        final Logger logger = Logger.getLogger("main");
        logger.log(Level.INFO, "Saving invoice on database ={0}", invoice);
    }
}
