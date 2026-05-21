```xml
<result>
    <code>
        <path>src/main/java/com/example/bookmarks/service/BookmarkService.java</path>
        <content><![CDATA[
package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class BookmarkService {

    /**
     * Fetches the title from a given URL.
     *
     * @param urlString The URL to fetch the title from.
     * @return The title of the webpage.
     * @throws IOException If the URL is inaccessible or the page does not contain a title.
     */
    public String fetchTitleFromUrl(String urlString) throws IOException {
        Document document = Jsoup.connect(urlString).get();
        return document.title();
    }
}
]]></content>
    </code>
</result>
```