package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.budget.Budget;
import com.cprt.store.budget.BudgetItem;

@SpringBootTest
class TestStoreApplicationComposite {

	private static final Logger LOGGER = Logger.getLogger("main");
	private static final String BASE_LOG = "{0} = {1}";

	@Test
	void execute() {
		LOGGER.log(Level.INFO, "Composite -------------------------------");
		Budget old = new Budget(new BudgetItem(new BigDecimal("200")));
		old.reprove();
		Budget newBudget = new Budget(new BudgetItem(new BigDecimal("500")));
		newBudget.addItem(old);

		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { newBudget, newBudget.getValue() });
		assertEquals(new BigDecimal("700"), newBudget.getValue(), "Value = 700");
	}

}
