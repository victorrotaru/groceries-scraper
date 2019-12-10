package com.sainsbury.scraper.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupReader {
    
    public Document readDocument(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
}
