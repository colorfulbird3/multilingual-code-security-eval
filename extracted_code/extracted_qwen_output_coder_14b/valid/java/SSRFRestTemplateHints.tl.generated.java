package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    public String getPageContent(String url) {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (RestClientException e) {
            // Handle exceptions such as network errors, invalid URLs, etc.
            e.printStackTrace();
            return null; // or throw a custom exception if needed
        }
    }
}