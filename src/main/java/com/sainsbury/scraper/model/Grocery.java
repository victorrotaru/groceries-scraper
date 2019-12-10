package com.sainsbury.scraper.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Grocery {
    
    private String title;
	private Integer caloriesPerHundredGrams;
	private BigDecimal unitPrice;
	private String description;

    public Grocery() {
    }

    public Grocery(String title, Integer caloriesPerHundredGrams, BigDecimal unitPrice, String description) {
        this.title = title;
        this.caloriesPerHundredGrams = caloriesPerHundredGrams;
        this.unitPrice = unitPrice;
        this.description = description;
    }

    public Grocery(String title, BigDecimal unitPrice, String description) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.description = description;
    }

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("kcal_per_100g")
	public Integer getCaloriesPerHundredGrams() {
		return caloriesPerHundredGrams;
	}
	
	public void setCaloriesPerHundredGrams(Integer caloriesPerHundredGrams) {
		this.caloriesPerHundredGrams = caloriesPerHundredGrams;
	}
	
	@JsonProperty("unit_price")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

    @Override
    public String toString() {
        return "Grocery{" + "title=" + title + ", caloriesPerHundredGrams=" + caloriesPerHundredGrams 
                + ", unitPrice=" + unitPrice + ", description=" + description + '}';
    }

}
