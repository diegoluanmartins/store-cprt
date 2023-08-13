package com.cprt.store;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cprt.store.budget.Budget;import com.cprt.store.tax.TaxCalculator;
import com.cprt.store.tax.TaxType;

@SpringBootTest
class StoreApplicationTests {

	@Test
	void contextLoads() {
		assertArrayEquals(Arrays.asList(1,2).toArray(), Arrays.asList(1,2).toArray(), "simple test");
	}

	@Test
	void BudgetTest(){
		Budget budget = new Budget(new BigDecimal("100"));
		TaxCalculator calculator = new TaxCalculator();
		assertEquals(new BigDecimal("10.0"), calculator.calculate(budget, TaxType.ICMS), "testing ICMS");
		assertEquals(new BigDecimal("60.0"), calculator.calculate(budget, TaxType.ISS), "testing ISS");
	}

}
