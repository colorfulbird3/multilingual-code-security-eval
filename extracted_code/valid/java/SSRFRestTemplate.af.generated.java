package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service class to fetch the HTML content of a web page.
 */
@Service
public class WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches the HTML content of a web page.
     * @param url The URL of the web page to fetch.
     * @return The HTML content as a string.
     */
    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch content from URL: " + url, e);
        }
    }
}