package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Extract title and description using regex
                String title = extractTitle(content.toString());
                String description = extractDescription(content.toString());

                return "<html><head><title>" + title + "</title></head><body><p>" + description + "</p></body></html>";
            } else {
                return "Failed to fetch content. Response Code: " + responseCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error fetching content: " + e.getMessage();
        }
    }

    private String extractTitle(String html) {
        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "No title found";
    }

    private String extractDescription(String html) {
        Pattern pattern = Pattern.compile("<meta\\s+name=\"description\"\\s+content=\"(.*?)\"\\s*>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "No description found";
    }
}