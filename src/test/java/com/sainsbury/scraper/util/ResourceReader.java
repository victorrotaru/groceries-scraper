package com.sainsbury.scraper.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ResourceReader {

    private ResourceReader() {
    }
    
    public static Document getTestDocument(String fileName) throws Exception {
        ClassLoader classLoader = ResourceReader.class.getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        StringWriter output = new StringWriter();
        BufferedReader r = new BufferedReader(new FileReader(file));
        String line;
        while ((line = r.readLine()) != null) {
            output.write(line);
        }
        return Jsoup.parse(output.toString());
    }
    
}
