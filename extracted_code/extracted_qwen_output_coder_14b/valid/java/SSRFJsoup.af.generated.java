package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        // Verbind met die URL en laai die HTML-inhoud
        Document document = Jsoup.connect(urlString).get();
        
        // Kry die titel van die bladsy
        String title = document.title();
        
        // Kontroleer of die titel leeg is en wys 'n fout indien dit so is
        if (title == null || title.isEmpty()) {
            throw new IOException("Die bladsy het geen geldige titel.");
        }
        
        return title;
    }
}