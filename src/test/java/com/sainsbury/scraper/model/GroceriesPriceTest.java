package com.sainsbury.scraper.model;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class GroceriesPriceTest {
    
    public GroceriesPriceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void shouldCalculateVat_NonZeroTotal() {
        GroceriesPrice actual = new GroceriesPrice(new BigDecimal(25.78d));
        assertThat(actual.getVat().doubleValue(), closeTo(4.3, 0.001));
    }
    
    @Test
    public void shouldCalculateVat_ZeroTotal() {
        GroceriesPrice actual = new GroceriesPrice(new BigDecimal(0));
        assertThat(actual.getVat().doubleValue(), closeTo(0, 0.001));
    }
    
    @Test
    public void shouldCalculateVat_NullTotal() {
        GroceriesPrice actual = new GroceriesPrice(null);
        assertThat(actual.getVat().doubleValue(), closeTo(0, 0.001));
    }
    
    @Test
    public void shouldCalculateVat_EmptyConstructor() {
        GroceriesPrice actual = new GroceriesPrice(null);
        assertThat(actual.getVat().doubleValue(), closeTo(0, 0.001));
    }
}
