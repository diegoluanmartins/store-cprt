package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.budget.Budget;
import com.cprt.store.tax.TaxCalculator;
import com.cprt.store.tax.TaxICMS;
import com.cprt.store.tax.TaxISS;

@SpringBootTest
class StoreApplicationTests {

	@Test
	void contextLoads() {
		assertArrayEquals(Arrays.asList(1,2).toArray(), Arrays.asList(1,2).toArray(), "simple test");
	}

	@Test
	void BudgetTest(){
		Budget budget = new Budget(new BigDecimal("100"), 1);
		TaxCalculator calculator = new TaxCalculator();
		assertEquals(new BigDecimal("10.0"), calculator.calculate(budget, new TaxICMS()), "testing ICMS");
		assertEquals(new BigDecimal("6.00"), calculator.calculate(budget, new TaxISS()), "testing ISS");
	}

}
