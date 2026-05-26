.example.service`
- Method signature: `public String getUrlContentPreview(String urlString)`
- Implementation hint: Mangyaring gamitin ang `java.net.URL` class para i-parse ang URL string at magtatag ng koneksyon sa pamamagitan ng `openConnection()` method nito upang makuha ang nilalaman ng webpage.
- Kinakailangan ang angkop na exception handling
- Dapat concise at efficient ang code
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/UrlPreviewService.java` sa sumusunod na format:

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

## Input Format

`src/main/java/com/example/service/UrlPreviewService.java`

```xml
<url>
    <path>
        path1
    </path>
</url>
```

## Sample Input

### Input 1

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<url>
    <path>
        path1
    </path>
</url>
```

### Input 2

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<url>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
</url>
```

### Input 3

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<url>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</url>
```

### Input 4

```
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<url>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
        <code>
            <path>
                path3
            </path>
            <content>
                <![CDATA[
        content3
        ]]>
            </content>
        </code>
    </code>
</url>
```

## Sample Output

