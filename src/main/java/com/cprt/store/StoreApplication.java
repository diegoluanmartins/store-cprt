package com.cprt.store;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cprt.store.budget.Budget;
import com.cprt.store.budget.BudgetItem;
import com.cprt.store.budget.BudgetProxy;

@SpringBootApplication
public class StoreApplication {

	private static final Logger LOGGER = Logger.getLogger("main");
	private static final String BASE_LOG = "{0} = {1}";

	public static void main(String[] args) {
		execute();
		// Try this after SpringApplication.run(StoreApplication.class, args)
		// to run api
	}

	public static void execute() {
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
	}

}
