package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.budget.Budget;
import com.cprt.store.budget.BudgetDAO;
import com.cprt.store.budget.BudgetItem;
import com.cprt.store.budget.state.Completed;
import com.cprt.store.discount.DiscountCalculator;
import com.cprt.store.http.HttpClientStore;

@SpringBootTest
class TestStoreApplicationAdapter {

	private static final Logger LOGGER = Logger.getLogger("main");
	private static final String BASE_LOG = "{0} = {1}";

	@Test
	void testAdapter(){
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
		assertEquals(new Completed(), budget1.getState(), "Is completed");
	}

}
