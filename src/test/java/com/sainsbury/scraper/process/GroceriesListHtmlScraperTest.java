package com.sainsbury.scraper.process;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsIn.isOneOf;

import com.sainsbury.scraper.model.Grocery;
import com.sainsbury.scraper.util.JsoupReader;
import com.sainsbury.scraper.util.ResourceReader;

public class GroceriesListHtmlScraperTest {
    
    private static final String TEST_DOCUMENT_LIST = "test_page_list.html";
    private static final String TEST_DOCUMENT_GROCERY = "test_page_item_blu.html";
    
    private static final JsoupReader reader = mock(JsoupReader.class);
    
    public GroceriesListHtmlScraperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void shouldReadGroceries() throws Exception {
        when(reader.readDocument(Matchers.anyString())).thenReturn(ResourceReader.getTestDocument(TEST_DOCUMENT_LIST));
        GroceriesListHtmlScraper scraper = new GroceriesListHtmlScraper(TEST_DOCUMENT_LIST);
        scraper.setJsoupReader(reader);
        List<Grocery> groceries = scraper.readGroceries();
        assertThat(groceries.size(), equalTo(2));
        for (Grocery grocery : groceries) {
            assertThat(grocery.getTitle(), isOneOf("Sainsbury's Strawberries 400g", "Sainsbury's Blueberries 200g"));
            assertThat(grocery.getUnitPrice().toPlainString(), isOneOf("1.75", "8.75"));
        }
    }
    
}
