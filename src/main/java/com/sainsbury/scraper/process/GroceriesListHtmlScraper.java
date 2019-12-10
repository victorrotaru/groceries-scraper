package com.sainsbury.scraper.process;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.sainsbury.scraper.model.Grocery;
import com.sainsbury.scraper.util.JsoupReader;

public class GroceriesListHtmlScraper {

    private static final String PRODUCT_MARKUP = "div.product";
    private static final String PRODUCT_INFO_MARKUP = "div.productInfo";
    private static final String PRODUCT_NAME_MARKUP = "div.productNameAndPromotions";
    private static final String PRICE_PER_UNIT_MARKUP = "p.pricePerUnit";

    private final String url;
    private GroceryHtmlScraper groceryScraper;
    private Document document;
    private JsoupReader jsoupReader;

    public GroceriesListHtmlScraper(String url) {
        this.url = url;
        jsoupReader = new JsoupReader();
    }

    public List<Grocery> readGroceries() throws IOException {
        Elements elements = getDocument().select(PRODUCT_MARKUP);

        List<Grocery> groceries = new ArrayList<>();
        for (Element element : elements) {
            groceries.add(readGrocery(element));
        }

        return groceries;
    }

    public void setJsoupReader(JsoupReader jsoupReader) {
        this.jsoupReader = jsoupReader;
    }

    private Grocery readGrocery(final Element element) throws IOException {

        Grocery grocery = new Grocery();
        grocery.setTitle(readGroceryTitle(element));
        grocery.setUnitPrice(new BigDecimal(readGroceryUnitPrice(element)));

        groceryScraper = new GroceryHtmlScraper(readGroceryPageUrl(element));
        grocery.setDescription(groceryScraper.readDescription());
        grocery.setCaloriesPerHundredGrams(groceryScraper.readCalories());

        return grocery;
    }

    private String readGroceryTitle(final Element element) {
        Element name = element.select(PRODUCT_INFO_MARKUP).select(PRODUCT_NAME_MARKUP).select("a").first();
        String title = name.html().replaceAll("<img.*", "").trim();
        return Parser.unescapeEntities(title, true);
    }

    private String readGroceryPageUrl(final Element element) {
        Element name = element.select(PRODUCT_INFO_MARKUP).select(PRODUCT_NAME_MARKUP).select("a").first();
        return name.attr("abs:href");
    }

    private String readGroceryUnitPrice(final Element element) {
        Element link = element.select(PRICE_PER_UNIT_MARKUP).first();
        return link.html().replaceAll("<abbr.*", "").substring(2);
    }

    private Document getDocument() throws IOException {
        if (document == null) {
            document = jsoupReader.readDocument(url);
        }
        return document;
    }
}
