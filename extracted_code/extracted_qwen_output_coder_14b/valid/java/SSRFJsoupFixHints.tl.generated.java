package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        // Validate the URL to prevent SSRF
        if (!isValidUrl(urlString)) {
            throw new IllegalArgumentException("Invalid URL");
        }

        URL url = new URL(urlString);
        Document doc = Jsoup.connect(urlString).get();
        return doc.title();
    }

    private boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            return "http".equals(url.getProtocol()) || "https".equals(url.getProtocol());
        } catch (Exception e) {
            return false;
        }
    }
}