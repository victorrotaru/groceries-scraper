package com.sainsbury.scraper.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Groceries {

    private List<Grocery> results;	
	private GroceriesPrice total;

    public Groceries() {
    }

    public Groceries(List<Grocery> results) {
        this.results = results;
        setTotal(new GroceriesPrice(calculateTotal()));
    }

    public List<Grocery> getResults() {
        return results;
    }

    public void setResults(List<Grocery> results) {
        this.results = results;
    }

    public GroceriesPrice getTotal() {
        return total;
    }

    public void setTotal(GroceriesPrice total) {
        this.total = total;
    }

    private BigDecimal calculateTotal() {
        BigDecimal result = new BigDecimal(0);
        result.setScale(2);
        if (results == null || results.isEmpty()) {
            return result;
        }
        
        for (Grocery grocery : results) {
            result = result.add(grocery.getUnitPrice());
        }

        return result;
    }
    
}
