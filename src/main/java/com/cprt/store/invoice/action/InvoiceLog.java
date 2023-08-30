package com.cprt.store.invoice.action;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.cprt.store.invoice.Invoice;

public class InvoiceLog implements InvoiceCreationAction {

    private static final Logger LOGGER = Logger.getLogger("main");

    @Override
    public void execute(Invoice invoice) {
        LOGGER.log(Level.INFO, "Generated invoice {0}", invoice);
    }

}
