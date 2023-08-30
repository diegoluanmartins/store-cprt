package com.cprt.store;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cprt.store.budget.Budget;
import com.cprt.store.budget.BudgetDAO;
import com.cprt.store.budget.BudgetItem;
import com.cprt.store.discount.DiscountCalculator;
import com.cprt.store.http.HttpClientStore;
import com.cprt.store.invoice.CreateInvoice;
import com.cprt.store.invoice.CreateInvoiceHandler;
import com.cprt.store.invoice.action.InvoiceLog;
import com.cprt.store.invoice.action.SaveInvoiceOnDatabase;
import com.cprt.store.invoice.action.SendInvoiceEmail;
import com.cprt.store.tax.TaxCalculator;
import com.cprt.store.tax.TaxICMS;
import com.cprt.store.tax.TaxISS;

@SpringBootApplication
public class StoreApplication {

	private static final Logger LOGGER = Logger.getLogger("main");
	private static final String BASE_LOG = "{0} = {1}";

	public static void main(String[] args) {
		testComposition();
		// SpringApplication.run(StoreApplication.class, args);
	}

	public static void testComposition(){
		LOGGER.log(Level.INFO, "Composition -------------------------------");
		Budget old = new Budget(new BudgetItem(new BigDecimal("200")));
		old.reprove();
		Budget newBudget = new Budget(new BudgetItem(new BigDecimal("500")));
		newBudget.addItem(old);
		
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { newBudget, newBudget.getValue() });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { newBudget, newBudget.getValue() });
	}

}
