package com.example.service;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try {
            URL url = new URL(resourceUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000); // 5 seconds timeout

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                return IOUtils.toByteArray(inputStream);
            } else {
                throw new RuntimeException("Failed to retrieve resource: HTTP error code " + connection.getResponseCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve resource: " + e.getMessage(), e);
        }
    }

}