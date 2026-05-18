```xml
<result>
    <code>
        <path>src/main/java/com/example/bookmarks/service/BookmarkService.java</path>
        <content>
            <![CDATA[
package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        Document doc = Jsoup.connect(url).get();
        return doc.title();
    }
}
            ]]>
        </content>
    </code>
</result>
```