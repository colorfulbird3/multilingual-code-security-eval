package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class BookmarkService {

    /**
     * Fetches the title from the given URL.
     *
     * @param urlString The URL to fetch the title from.
     * @return The title of the webpage.
     * @throws IOException If an I/O error occurs while fetching the URL or parsing the HTML.
     */
    public String fetchTitleFromUrl(String urlString) throws IOException {
        // Connect to the URL and get the document
        Document document = Jsoup.connect(urlString).get();
        
        // Get the title element
        Element titleElement = document.title();
        
        // Check if the title element exists
        if (titleElement != null) {
            return titleElement.text();
        } else {
            throw new IOException("No title found for the given URL.");
        }
    }
}