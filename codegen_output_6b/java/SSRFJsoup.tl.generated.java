: Gamitin ang `org.jsoup.Jsoup.connect(urlString)` upang magtatag ng koneksyon at makuha ang document object.
- Kinakailangan ang naaangkop na exception handling
- Ang code ay dapat concise at efficient

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/bookmarks/service/BookmarkService.java` sa sumusunod na format:

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

## Notes

- Ang code ang magasay ng `org.jsoup.Jsoup.connect()` nado nagtataktas ng `java.net.URL` nagitan ng HTML content ng URL sa loob ng `String` ang URL na pangalan ng bookmark.
- Ang code ay dapat concise at efficient, sa nang kontinue ang pag-pagina at i-parse ang HTML kung nagdagdag ng pag-pagina ang pagina ay nagtataktas ng HTML content ng URL sa loob ng `String` ang URL na pangalan ng bookmark.
- Ang code ang magasay ng `org.jsoup.Jsoup.connect()` nado nagtataktas ng `java.net.URL` nagitan ng HTML content ng URL sa loob ng `java.lang.String` ang URL na pangalan ng bookmark.

**/
package com.example.bookmarks.service;