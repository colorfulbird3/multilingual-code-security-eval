package com.example.bookmarks.service;

   import org.jsoup.Jsoup;
   import org.jsoup.nodes.Document;

   public class BookmarkService {

       public String fetchTitleFromUrl(String urlString) throws IOException {
           // Connect to the URL and parse the HTML
           Document document = Jsoup.connect(urlString).get();
           
           // Extract the title from the HTML document
           String title = document.title();
           
           return title;
       }
   }