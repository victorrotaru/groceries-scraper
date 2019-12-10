package com.sainsbury.scraper.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sainsbury.scraper.model.Groceries;

public class JsonSerializer {

    private JsonSerializer() {
    }
    
    public static String toJson(final Groceries groceries) throws JsonProcessingException {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(groceries);
    }
}
