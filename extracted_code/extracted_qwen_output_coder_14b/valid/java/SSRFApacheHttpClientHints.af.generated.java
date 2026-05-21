package com.example.service;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UrlService {

    public String fetchUrlContent(String userUrl) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(userUrl);
        StringBuilder responseContent = new StringBuilder();

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            if (response.getStatusLine().getStatusCode() == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                responseContent.append(responseBody);
            } else {
                responseContent.append("Failed to retrieve content. HTTP Status Code: ").append(response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            responseContent.append("An error occurred while fetching the URL content: ").append(e.getMessage());
        }

        return responseContent.toString();
    }
}