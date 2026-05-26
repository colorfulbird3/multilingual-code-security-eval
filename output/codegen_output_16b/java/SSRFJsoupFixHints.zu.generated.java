String urlString) throws IOException {
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


## Ifomethi sekhasi kukhodi

Sekhasi ikhodi yekondelo yee-BookmarkService.java, lewebhu lokuhlola:

```java
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class BookmarkService {

    public String fetchTitleFromUrl(String urlString) throws IOException {
        URL url = new URL(urlString);
        Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
        return doc.title();
    }
}
```
