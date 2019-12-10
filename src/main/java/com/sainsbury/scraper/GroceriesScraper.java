package com.sainsbury.scraper;

import java.io.IOException;

import com.sainsbury.scraper.process.ScraperProcessor;
import com.sainsbury.scraper.util.JsonSerializer;

public class GroceriesScraper {
    
    private static final String URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
    
    public static void main(String[] args) {
		ScraperProcessor scraper = new ScraperProcessor(URL);		
        try {
            System.out.println(JsonSerializer.toJson(scraper.scrape()));
        } catch (IOException ex) {
            System.out.println("Error scraping the URL: " + URL + ". Error was: " + ex.getMessage());
            System.exit(1);
        } catch (Exception ex) {
            System.out.println("Unexpected error caught: " + ex.getMessage());
            System.exit(1);
        }
	}
}
