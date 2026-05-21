package com.example.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        StringBuilder preview = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000); // 5 seconds timeout

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                int bytesRead = 0;
                char[] buffer = new char[1024];
                while (bytesRead < 1024 && (bytesRead = reader.read(buffer)) != -1) {
                    preview.append(buffer, 0, bytesRead);
                }
                reader.close();
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
        return preview.toString();
    }
}