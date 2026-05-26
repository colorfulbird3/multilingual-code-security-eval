

## Bepaal

Hieronder bepaal dat die bladmerk-URL-titel-funkcie daadwerpslaat met die verdere uitvoer van de Service-toepassing.

```java
package com.example.bookmarks.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class BookmarkService {
    // Implementasie van de 'fetchTitleFromUrl'-metode.
    public String fetchTitleFromUrl(String urlString) throws IOException {
        try {
            URL url = new URL(urlString);
            Document doc = Jsoup.connect(urlString).get();
            Elements titleElements = doc.select("title");
            
            if (titleElements.isEmpty()) {
                throw new IOException("No title found");
            } else {
                Element titleElement = titleElements.first();
                return titleElement.text();
            }
        } catch (MalformedURLException e) {
            throw new IOException("Malformed URL");
        }
    }
}
```

## Aanmerking

- Daardie `<title>`-etiket word ondersteun. Daardie verstel om 'n bekende bladmerk-titel in te voeg. Daardie moet aanvullen na die bladmerk-titel van die bladmerk-URL en daardie moet 'n titel waarsom en kort afkantie gebruik word.
- Daardie moet 'n tekst na de bladmerk-URL bevoorlopig verwys. Om die verwys naar die bladmerk-URL te verschuif, moet die URL-toepassing