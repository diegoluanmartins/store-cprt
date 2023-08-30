package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.budget.Budget;
import com.cprt.store.budget.BudgetItem;
import com.cprt.store.budget.state.Completed;
import com.cprt.store.discount.DiscountCalculator;

@SpringBootTest
class TestStoreApplicationDiscount {

	private static final Logger LOGGER = Logger.getLogger("main");
	private static final String BASE_LOG = "{0} = {1}";


	@Test
	void testBudgetDiscounts() {
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
		assertEquals(new Completed(), budget1.getState(), "Is completed");
	}

}
