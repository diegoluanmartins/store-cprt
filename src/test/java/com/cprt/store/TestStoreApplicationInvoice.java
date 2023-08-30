package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.invoice.CreateInvoice;
import com.cprt.store.invoice.CreateInvoiceHandler;
import com.cprt.store.invoice.action.InvoiceLog;
import com.cprt.store.invoice.action.SaveInvoiceOnDatabase;
import com.cprt.store.invoice.action.SendInvoiceEmail;

@SpringBootTest
class TestStoreApplicationInvoice {

	private static final Logger LOGGER = Logger.getLogger("main");

	@Test
	void execute() {
		LOGGER.log(Level.INFO, "Invoice ------------------------------------");
		String[] args = new String[] { "Cptr Customer", "1000", "4" };
		String customerName = args[0];
		BigDecimal budgetValue = new BigDecimal(args[1]);
		int qtyOfItem = Integer.parseInt(args[2]);

		CreateInvoice invoiceCreator = new CreateInvoice(customerName, budgetValue, qtyOfItem);
		CreateInvoiceHandler invoiceCreatorHandler = new CreateInvoiceHandler(
				Arrays.asList(
						new SaveInvoiceOnDatabase(),
						new SendInvoiceEmail(),
						new InvoiceLog()));
		invoiceCreatorHandler.execute(invoiceCreator);
		assertEquals(new BigDecimal("1000"), invoiceCreator.getBudgetValue(), "Value = 1000");
	}

}
