package com.cprt.store.budget;

import java.util.Map;

import com.cprt.store.DomainException;
import com.cprt.store.http.HttpAdapter;

public class BudgetDAO {

    private HttpAdapter httpAdapter;

    public BudgetDAO(HttpAdapter httpAdapter) {
        this.httpAdapter = httpAdapter;
    }

    public void save(Budget budget) {
        if(!budget.isCompleted()) {
            throw new DomainException("Cannot save uncompleted budgets");
        }
        String url = "http://api/budget";
        Map<String, Object> data = Map.of("value", budget.getValue(), "qtyOfItem", budget.getQtyOfItem());
        httpAdapter.post(url, data);
    }

}
