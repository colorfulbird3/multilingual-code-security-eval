Hier is die volledige Java-kode voor die `BookmarkService`-klas met die `fetchTitleFromUrl`-metode:

```xml
<result>
    <code>
        <path>src/main/java/com/example/bookmarks/service/BookmarkService.java</path>
        <content><![CDATA[
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
]]></content>
    </code>
</result>
```

### Uitleg van die kode:

1. **Pakketnaam**: Die klas word in die pakket `com.example.bookmarks.service` geplaas.
2. **Klasnaam**: Die klas word genaamd `BookmarkService`.
3. **Metode-handtekening**: Die `fetchTitleFromUrl`-metode neem 'n `String`-parameter (`urlString`) en gee 'n `String`-returnwaarde terug. Dit kan 'n `IOException` veroorsaak.
4. **Implementering**:
   - Die `Jsoup.connect(urlString).get()`-methode word gebruik om 'n verbinding te vestig met die gegewe URL en die HTML-document te verkry.
   - Die `document.title()`-methode word gebruik om die `<title>`-element te verkry.
   - Die `titleElement.text()`-methode word gebruik om die teks van die `<title>`-element te verkry.
   - Indien die `<title>`-element nie bestaan nie, word 'n `IOException` geworpen met die bericht "No title found for