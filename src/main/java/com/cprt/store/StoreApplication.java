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
		testBudgetTax();
		testBudgetDiscounts();
		testInvoice(new String[] { "Cptr Customer", "1000", "4" });
		testComposition();
		// SpringApplication.run(StoreApplication.class, args);
	}

	public static void testBudgetTax() {
		LOGGER.log(Level.INFO, "Tax ------------------------------------");
		Budget budget = new Budget(new BudgetItem(new BigDecimal("100")));
		TaxCalculator calculator = new TaxCalculator();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "ISS", calculator.calculate(budget, new TaxISS()) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "ICMS", calculator.calculate(budget, new TaxICMS()) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "ICMS and ISS", calculator.calculate(budget, new TaxICMS(new TaxISS())) });
	}

	public static void testBudgetDiscounts() {
		LOGGER.log(Level.INFO, "Discount -------------------------------");
		
		Budget budget1 = new Budget();
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(new BigDecimal("60")));

		Budget budget2 = new Budget();
		budget2.addItem(new BudgetItem(BigDecimal.TEN));
		budget2.addItem(new BudgetItem(BigDecimal.TEN));
		budget2.addItem(new BudgetItem(BigDecimal.TEN));
		budget2.addItem(new BudgetItem(BigDecimal.TEN));
		budget2.addItem(new BudgetItem(BigDecimal.TEN));
		budget2.addItem(new BudgetItem(new BigDecimal("60")));

		Budget budget3 = new Budget();
		budget3.addItem(new BudgetItem(BigDecimal.valueOf(100)));
		budget3.addItem(new BudgetItem(BigDecimal.valueOf(100)));
		budget3.addItem(new BudgetItem(BigDecimal.valueOf(100)));
		budget3.addItem(new BudgetItem(BigDecimal.valueOf(100)));
		budget3.addItem(new BudgetItem(new BigDecimal("600")));
		
		DiscountCalculator calculator = new DiscountCalculator();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget2, calculator.calculate(budget2) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget3, calculator.calculate(budget3) });
		budget1.applyExtraDiscount();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
		budget1.approve();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
		budget1.applyExtraDiscount();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
		budget1.reprove();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
		budget1.complete();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
	}

	public static void testInvoice(String[] args) {
		LOGGER.log(Level.INFO, "Invoice ------------------------------------");
		String customerName = args[0];
		BigDecimal budgetValue = new BigDecimal(args[1]);
		int qtyOfItem = Integer.parseInt(args[2]);

		CreateInvoice invoiceCreator = new CreateInvoice(customerName, budgetValue, qtyOfItem);
		CreateInvoiceHandler invoiceCreatorHandler = new CreateInvoiceHandler(
				Arrays.asList(
					new SaveInvoiceOnDatabase(), 
					new SendInvoiceEmail()
					));
		invoiceCreatorHandler.execute(invoiceCreator);
	}

	public static void testAdapter(){
		LOGGER.log(Level.INFO, "Discount -------------------------------");
		
		Budget budget1 = new Budget();
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(BigDecimal.TEN));
		budget1.addItem(new BudgetItem(new BigDecimal("60")));

		DiscountCalculator calculator = new DiscountCalculator();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget1, calculator.calculate(budget1) });
		budget1.approve();
		budget1.complete();
		BudgetDAO budgetDao = new BudgetDAO(new HttpClientStore());
		budgetDao.save(budget1);
	}

	public static void testComposition(){
		Budget old = new Budget(new BudgetItem(new BigDecimal("200")));
		old.reprove();
		Budget newBudget = new Budget(new BudgetItem(new BigDecimal("500")));
		newBudget.addItem(old);
		
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { newBudget, newBudget.getValue() });
	}

}
