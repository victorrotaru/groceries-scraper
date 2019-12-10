package com.sainsbury.scraper.process;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import com.sainsbury.scraper.util.JsoupReader;

public class GroceryHtmlScraper {
    
    private static final String PRODUCT_TEXT_MARKUP = "div.productText p";
    private static final String NUTRITION_TEXT_MARKUP = "table.nutritionTable tbody tr td.nutritionLevel1";
    private static final String KILO_CALORIES = "kcal";
    
    private final String url;
    private Document document;
    private JsoupReader jsoupReader;

    public GroceryHtmlScraper(String url) {
        this.url = url;
        jsoupReader = new JsoupReader();
    }
    
    public String readDescription() throws IOException {		
		String description = getDocument().select(PRODUCT_TEXT_MARKUP).first().html();		
		return Parser.unescapeEntities(description, true);
	}
	
	public Integer readCalories() throws IOException {
		Element element = getDocument().select(NUTRITION_TEXT_MARKUP).first();
		if (element == null) {
			return null;
		}		
		String calories = element.html().replaceAll(KILO_CALORIES, "");
		return new Integer(calories);
	}

    public void setJsoupReader(JsoupReader jsoupReader) {
        this.jsoupReader = jsoupReader;
    }
	
	private Document getDocument() throws IOException {	
        if (document == null) {
            document = jsoupReader.readDocument(url);
        }
		return document;
	}
    
}
