package com.cprt.store;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cprt.store.budget.Budget;
import com.cprt.store.tax.TaxCalculator;
import com.cprt.store.tax.TaxICMS;
import com.cprt.store.tax.TaxISS;

@SpringBootApplication
public class StoreApplication {

	private static final Logger logger = Logger.getLogger("main");
	public static void main(String[] args) {
		testBudget();
		//SpringApplication.run(StoreApplication.class, args);
	}

	public static void testBudget(){
		Budget budget = new Budget(new BigDecimal("100"));
		TaxCalculator calculator = new TaxCalculator();
		logger.log(Level.INFO, "{0} = {1}", new Object[]{"ISS", calculator.calculate(budget, new TaxISS())});
		logger.log(Level.INFO, "{0} = {1}", new Object[]{"ICMS", calculator.calculate(budget, new TaxICMS())});
		
	}

}
