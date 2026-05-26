```xml
<result>
    <code>
        <path>
            src/main/java/com/example/bookmarks/service/BookmarkService.java
        </path>
        <content>
            <![CDATA[
package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            Document doc = Jsoup.connect(urlString).get();
            return doc.title();
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + urlString);
            return null;
        } catch (IOException e) {
            System.out.println("Failed to fetch title from URL: " + urlString);
            return null;
        }
    }
}
]]>
        </content>
    </code>
</result>
```