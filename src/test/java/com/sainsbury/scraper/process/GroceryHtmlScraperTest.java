package com.sainsbury.scraper.process;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Matchers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

import com.sainsbury.scraper.util.JsoupReader;
import com.sainsbury.scraper.util.ResourceReader;

@RunWith(MockitoJUnitRunner.class)
public class GroceryHtmlScraperTest {
    
    private static final String TEST_DOCUMENT_BLU = "test_page_item_blu.html";
    private static final String TEST_DOCUMENT_STR = "test_page_item_str.html";
    
    private static final JsoupReader reader = mock(JsoupReader.class);
    
    public GroceryHtmlScraperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReadGroceyDescriptionOnly() throws Exception {
        when(reader.readDocument(Matchers.anyString())).thenReturn(ResourceReader.getTestDocument(TEST_DOCUMENT_BLU));
        GroceryHtmlScraper scraper = new GroceryHtmlScraper(TEST_DOCUMENT_BLU);
        scraper.setJsoupReader(reader);
        assertThat(scraper.readDescription(), equalTo("by Sainsbury's blueberries"));
        assertThat(scraper.readCalories(), nullValue());
        
    }
    
    @Test
    public void shouldReadGroceyDescriptionAndCals() throws Exception {
        when(reader.readDocument(Matchers.anyString())).thenReturn(ResourceReader.getTestDocument(TEST_DOCUMENT_STR));
        GroceryHtmlScraper scraper = new GroceryHtmlScraper(TEST_DOCUMENT_STR);
        scraper.setJsoupReader(reader);
        assertThat(scraper.readDescription(), equalTo("by Sainsbury's strawberries"));
        assertThat(scraper.readCalories(), equalTo(33));
    }
    
}
