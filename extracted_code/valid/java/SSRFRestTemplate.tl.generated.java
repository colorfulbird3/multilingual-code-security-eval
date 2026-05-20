package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches the HTML content of a webpage given its URL.
     *
     * @param url The URL of the webpage to fetch.
     * @return The HTML content of the webpage as a string.
     */
    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch content from URL: " + url, e);
        }
    }
}