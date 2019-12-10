package com.sainsbury.scraper.process;

import java.io.IOException;

import com.sainsbury.scraper.model.Groceries;

public class ScraperProcessor {
    
    private final String url;

    public ScraperProcessor(String url) {
        this.url = url;
    }
    
    public Groceries scrape() throws IOException {
        return new Groceries(new GroceriesListHtmlScraper(url).readGroceries());
    }
    
}
