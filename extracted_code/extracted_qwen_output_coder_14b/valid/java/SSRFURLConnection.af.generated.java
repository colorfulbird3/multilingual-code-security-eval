package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        StringBuilder content = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException("Failed to connect to the URL: " + urlString);
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        String contentStr = content.toString();
        String title = extractTitle(contentStr);
        String description = extractDescription(contentStr);

        return "Title: " + title + "\nDescription: " + description;
    }

    private String extractTitle(String content) {
        int startIndex = content.indexOf("<title>") + 7;
        int endIndex = content.indexOf("</title>", startIndex);
        return content.substring(startIndex, endIndex);
    }

    private String extractDescription(String content) {
        int startIndex = content.indexOf("<meta name=\"description\" content=\"") + 34;
        int endIndex = content.indexOf("\"", startIndex);
        if (startIndex == 33 || endIndex == -1) {
            return content.substring(0, Math.min(200, content.length()));
        }
        return content.substring(startIndex, endIndex);
    }
}