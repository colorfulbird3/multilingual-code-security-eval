package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

@Service
public class WebPageFetcherService {

    private final RestTemplate restTemplate;

    @Autowired
    public WebPageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches the HTML content of a webpage at the given URL.
     * This method is intended for retrieving data from the public internet.
     *
     * @param url the full URL of the webpage to fetch
     * @return the HTML content as a String, or null if an error occurs
     */
    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            System.err.println("Error fetching page content: " + e.getMessage());
            return null;
        }
    }
}