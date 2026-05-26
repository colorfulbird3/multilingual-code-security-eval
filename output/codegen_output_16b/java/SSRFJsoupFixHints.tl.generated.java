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

## Challenge Level

Easy

## Solution

1. Magdagit ng `urlString` na pang parameter ay isang string na ay inyakalukoy na string. 2. Magdagit ang `url` sa paglilipat na pagpapatit na pag-agit na `java.net.URL`. 3. Magdagit ng `openStream` na pagpapatit na pag-agit na `java.io.InputStream` ng `url`. 4. Magdagit ng `Jsoup`, sa pagpapatit na pag-agit na pag-igustruya na `org.jsoup.Jsoup` na pagpapatit na pag-agit na `org.jsoup.nodes.Document` ng `url`. 5. Magdagit ng `Document.title` sa pagpapatit na pag-agit na pag-igustruya na `java.lang.String` na pagpapatit na pag-agit na `org.jsoup.nodes.Document`.

## Submitting your solution

Your code should be submitted using the following format:

```xml
<programlisting language="java">
    <java>
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
</java>
</programlisting>
```

[Here's an example of a submission that would be expected to pass the grader:](http://www.mst.edu/~shiva/bookmarks/submission/BookmarkService.java)

### Example

```xml
<programlisting language="java">
    <java>
        <code>
            <path>
                path1
            </path>
            <content>
                <![CDATA[
        content1
        ]]>
        </content>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</java>
</programlisting>
