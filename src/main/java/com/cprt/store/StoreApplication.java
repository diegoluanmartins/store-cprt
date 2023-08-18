package com.cprt.store;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cprt.store.budget.Budget;
import com.cprt.store.discount.DiscountCalculator;
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
		// SpringApplication.run(StoreApplication.class, args);
	}

	public static void testBudgetTax() {
		LOGGER.log(Level.INFO, "Tax ------------------------------------");
		Budget budget = new Budget(new BigDecimal("100"), 1);
		TaxCalculator calculator = new TaxCalculator();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "ISS", calculator.calculate(budget, new TaxISS()) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "ICMS", calculator.calculate(budget, new TaxICMS()) });
	}

	public static void testBudgetDiscounts() {
		LOGGER.log(Level.INFO, "Discount -------------------------------");
		Budget budget = new Budget(new BigDecimal("100"), 5);
		Budget budget2 = new Budget(new BigDecimal("100"), 6);
		Budget budget3 = new Budget(new BigDecimal("1000"), 5);
		DiscountCalculator calculator = new DiscountCalculator();
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget, calculator.calculate(budget) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget2, calculator.calculate(budget2) });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { budget3, calculator.calculate(budget3) });
	}

}
