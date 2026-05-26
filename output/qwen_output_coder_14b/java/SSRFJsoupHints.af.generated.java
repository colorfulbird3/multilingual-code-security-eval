Hier is die implementering van die `fetchTitleFromUrl`-metode binne die gespesifiseerde klas en metode:

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

public class BookmarkService {
    public String fetchTitleFromUrl(String urlString) throws IOException {
        try {
            Document document = Jsoup.connect(urlString).get();
            return document.title();
        } catch (IOException e) {
            throw new IOException("Fout bij ophalen van bladsytitel", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```

### Omskrywing:

1. **Pakketnaam**: `com.example.bookmarks.service`
2. **Klasnaam**: `BookmarkService`
3. **Metode-naam**: `fetchTitleFromUrl`
4. **Parameter**: `String urlString`
5. **Uitset**: `String` (bladsytitel) of `IOException` (indien URL ontoeganklik is)

### Implementering:

- Gebruik `Jsoup.connect(urlString).get()` om 'n verbinding te vestig en die HTML-dokument te verkry.
- Gebruik `document.title()` om die titel van die bladsy te onttrek.
- Sluit 'n `try-catch` blok om eventuele `IOException`s te hanteer en 'n toepaslike foutboodskap te wys.
- Geef die titel terug indien die ophaling suksesvol is, anders gooi 'n `IOException`.