package com.sainsbury.scraper.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GroceriesPrice {
    // 20% VAT
    private static final BigDecimal GROCERIES_VAT_PERCENT = new BigDecimal(20);
    
    private BigDecimal gross;
    private BigDecimal vat;

    public GroceriesPrice() {
        this.vat = new BigDecimal(0);
    }

    public GroceriesPrice(BigDecimal gross) {
        this.gross = gross;
        this.vat = calculateVat();
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }
        
    private BigDecimal calculateVat() {
        if (gross == null) {
            return new BigDecimal(0);
        }
        // VAT = TOTAL - TOTAL / (1 + (GROCERIES_VAT_PERCENT / 100))
        return gross.subtract(gross.divide((new BigDecimal(1)).add(GROCERIES_VAT_PERCENT.divide(new BigDecimal(100), 2, RoundingMode.HALF_DOWN)), 2, RoundingMode.HALF_DOWN));
    }
}
