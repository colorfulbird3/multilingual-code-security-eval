package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebPageFetcherService {

    private final RestTemplate restTemplate;

    @Autowired
    public WebPageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPageContent(String url) {
        try {
            // Make an HTTP GET request to fetch the webpage content
            String pageContent = restTemplate.getForObject(url, String.class);
            return pageContent;
        } catch (Exception e) {
            // Handle exceptions, such as connection errors or invalid URLs
            System.err.println("Failed to fetch page content: " + e.getMessage());
            return null;
        }
    }
}