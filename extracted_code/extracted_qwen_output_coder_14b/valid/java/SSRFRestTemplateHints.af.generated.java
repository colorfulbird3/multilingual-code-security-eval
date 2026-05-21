package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class WebPageFetcherService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches the HTML content of a web page given its URL.
     *
     * @param url the URL of the web page
     * @return the HTML content of the web page as a String
     * @throws HttpClientErrorException if an error occurs while fetching the web page
     */
    public String getPageContent(String url) throws HttpClientErrorException {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (HttpClientErrorException e) {
            throw new HttpClientErrorException(e.getStatusCode(), e.getStatusText(), e.getResponseBodyAsString(), e.getResponseHeaders(), e.getUri());
        }
    }
}