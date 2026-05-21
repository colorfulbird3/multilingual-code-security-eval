package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

public class WebPageFetcherService {

    private final RestTemplate restTemplate;

    @Autowired
    public WebPageFetcherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    public void fetch() {
        System.out.println("Fetching page: https://www.example.com");
        String pageContent = restTemplate.getForObject("https://www.example.com", String.class);
        System.out.println("Page content: " + pageContent);
    }
}