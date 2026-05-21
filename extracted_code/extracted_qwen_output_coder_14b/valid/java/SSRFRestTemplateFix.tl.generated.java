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

    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            System.err.println("Error fetching page content: " + e.getMessage());
            return null;
        }
    }
}