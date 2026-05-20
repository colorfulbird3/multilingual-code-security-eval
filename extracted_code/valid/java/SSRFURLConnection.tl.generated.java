package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            // Extract title and description (simplified example)
            String title = extractTitle(content.toString());
            String description = extractDescription(content.toString());

            return "<html><head><title>" + title + "</title></head><body><h1>" + title + "</h1><p>" + description + "</p></body></html>";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error fetching URL content";
        }
    }

    private String extractTitle(String html) {
        int start = html.indexOf("<title>") + 7;
        int end = html.indexOf("</title>");
        return html.substring(start, end);
    }

    private String extractDescription(String html) {
        int start = html.indexOf("<meta name=\"description\" content=\"") + 36;
        int end = html.indexOf("\"", start);
        return html.substring(start, end);
    }
}