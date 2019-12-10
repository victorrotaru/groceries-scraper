package com.sainsbury.scraper.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class GroceriesTest {
    
    public GroceriesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void shouldCalculateTotal_NonEmptyList() {
        List<Grocery> fixture = createGroceriesList();
        Groceries actual = new Groceries(fixture);
        assertThat(actual.getTotal().getGross().doubleValue(), closeTo(12.3, 0.001));
    }

    @Test
    public void shouldCalculateTotal_EmptyList() {
        List<Grocery> fixture = Collections.EMPTY_LIST;
        Groceries actual = new Groceries(fixture);
        assertThat(actual.getTotal().getGross().doubleValue(), closeTo(0, 0.001));
    }
    
    @Test
    public void shouldCalculateTotal_NullList() {
        List<Grocery> fixture = null;
        Groceries actual = new Groceries(fixture);
        assertThat(actual.getTotal().getGross().doubleValue(), closeTo(0, 0.001));
    }
    
    @Test
    public void shouldCalculateTotal_EmptyConstructor() {
        List<Grocery> fixture = null;
        Groceries actual = new Groceries(fixture);
        assertThat(actual.getTotal().getGross().doubleValue(), closeTo(0, 0.001));
    }


    private List<Grocery> createGroceriesList() {
        List<Grocery> groceries = new ArrayList<>();
        groceries.add(new Grocery("Title 1", new BigDecimal(2.55d), "Description 1"));
        groceries.add(new Grocery("Title 2", new BigDecimal(4.23d), "Description 2"));
        groceries.add(new Grocery("Title 3", new BigDecimal(3.65d), "Description 3"));
        groceries.add(new Grocery("Title 4", new BigDecimal(1.87d), "Description 4"));
        return groceries;
    }
    
}
