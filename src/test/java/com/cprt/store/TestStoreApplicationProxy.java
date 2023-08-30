package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.budget.Budget;
import com.cprt.store.budget.BudgetItem;
import com.cprt.store.budget.BudgetProxy;

@SpringBootTest
class TestStoreApplicationProxy {

	private static final Logger LOGGER = Logger.getLogger("main");
	private static final String BASE_LOG = "{0} = {1}";

	@Test
	void execute() {
		Long initial = System.currentTimeMillis();
		LOGGER.log(Level.INFO, "Proxy -------------------------------");
		Budget old = new Budget(new BudgetItem(new BigDecimal("200")));
		old.reprove();
		Budget newBudget = new Budget(new BudgetItem(new BigDecimal("500")));
		newBudget.addItem(old);
		BudgetProxy newBudgetProxy = new BudgetProxy(newBudget);

		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "newBudget", newBudgetProxy.getValue() });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] { "newBudget", newBudgetProxy.getValue() });
		LOGGER.log(Level.INFO, BASE_LOG, new Object[] {"Total time ", (System.currentTimeMillis() - initial)});
		assertEquals(new BigDecimal("700"), newBudgetProxy.getValue(), "Value = 700");
	}

}
