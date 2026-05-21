package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        // Validate the URL to prevent SSRF
        if (!isValidUrl(urlString)) {
            throw new IllegalArgumentException("Invalid URL");
        }

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setInstanceFollowRedirects(true);
        connection.connect();

        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to retrieve the webpage");
        }

        Document doc = Jsoup.parse(connection.getInputStream(), "UTF-8", urlString);
        return doc.title();
    }

    private boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            return url.getProtocol().equals("http") || url.getProtocol().equals("https");
        } catch (Exception e) {
            return false;
        }
    }
}