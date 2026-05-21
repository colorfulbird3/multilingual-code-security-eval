package com.example.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class UrlService {

    public String fetchUrlContent(String userUrl) {
        // Check if the provided URL is valid
        if (userUrl == null || userUrl.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(userUrl);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error fetching content from URL: " + userUrl, e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Error closing response", e);
            }
        }
        return null;
    }
}