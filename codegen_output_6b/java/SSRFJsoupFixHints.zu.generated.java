ungozi kukhodi elandelayo ye-Java.

```java
package com.example.bookmarks.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
        return doc.title();
    }
}
```



## Ifomethi Yokukhipha

Khipha ikhodi ephelele elungisiwe ye-`src/main/java/com/example/bookmarks/service/BookmarkService.java` ngefomethi elandelayo:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

#####

## Ikho

#####


- Uwe Wolkers
- Jure Schulte
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Schulte
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Matic
- Jure Kostak
- Jure Schulte
- Jure Kostak
- Jure Schulte
- Jure Riedl
- Jure Matic
- Jure Riedl
- Jure Matic
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Schulte
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Matic
- Jure Kostak
- Jure Schulte
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Matic
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- Jure Matic
- Jure Riedl
- Jure Kostak
- J