package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws java.io.IOException {
        try {
            Document document = Jsoup.connect(urlString).get();
            Elements titleElements = document.select("title");
            if (!titleElements.isEmpty()) {
                Element titleElement = titleElements.first();
                return titleElement.text();
            } else {
                throw new IOException("No title found in the HTML content.");
            }
        } catch (java.io.IOException e) {
            throw new java.io.IOException("Failed to access the URL or parse the HTML content.", e);
        }
    }
}