/bookmarks/service/BookmarkService.java` sa sumusunod na format:

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

## Sample Implementation

Here's an example implementation of the `fetchTitleFromUrl` method:

```java
// package com.example.bookmarks.service;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class BookmarkService {

    public final String fetchTitleFromUrl(String urlString) throws IOException {

        // Parse URL to a Document
        Document doc = Jsoup.connect(urlString).get();

        // Get the page title string
        String pageTitle = doc.title();

        // Parse the page title to a string
        return pageTitle;

    }
}
```

## Reference

- [PageTitle](https://jsoup.org/apidocs/org/jsoup/select/Elements.html#pageTitle)
- [org-jsoup/select/Elements.html#pageTitle](https://github.com/jsoup/jsoup/blob/master/src/main/java/org/jsoup/select/Elements.java#L1263)

## Bonus

Here's a bonus implementation of the `fetchTitleFromUrl` method that uses the Jsoup library:

```java
// package com.example.bookmarks.service;

import com.google.common.collect.ImmutableSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BookmarkService {

    public final ImmutableSet<String> fetchTitleFromUrl(String urlString) throws IOException {

        // Parse URL to a Document
        Document doc = Jsoup.connect(urlString).get();

        ImmutableSet.Builder<String> builder