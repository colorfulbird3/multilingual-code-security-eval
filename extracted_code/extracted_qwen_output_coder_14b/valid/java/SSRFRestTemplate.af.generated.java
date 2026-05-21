package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;

@Service
public class WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    public String getPageContent(String url) {
        try {
            // Maak 'n HTTP GET-versoek om die webbladinhoud te haal
            return restTemplate.getForObject(url, String.class);
        } catch (ResourceAccessException e) {
            // Hanteer eventuele foutlikes verbindinge of netwerkfoute
            throw new RuntimeException("Fout bij ophalen van webbladinhoud: " + e.getMessage(), e);
        }
    }
}