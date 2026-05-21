package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        // Validate the URL to prevent SSRF attacks
        if (!isValidUrl(url)) {
            throw new IllegalArgumentException("Invalid URL");
        }
        Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
        return doc.title();
    }

    private boolean isValidUrl(URL url) {
        try {
            // Check if the URL is within the allowed domain
            String host = url.getHost();
            if (host == null || !host.equals("example.com")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}