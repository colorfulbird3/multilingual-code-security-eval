package com.example.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class UrlService {

    public String fetchUrlContent(String userUrl) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(userUrl);
        StringBuilder responseBuilder = new StringBuilder();

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                responseBuilder.append(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseBuilder.append("An error occurred while fetching the URL content.");
        }

        return responseBuilder.toString();
    }
}