package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class BookmarkService {
    public String fetchTitleFromUrl(String urlString) throws IOException {
        Document document = Jsoup.connect(urlString).get();
        return document.title();
    }
}