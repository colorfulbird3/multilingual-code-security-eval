 string at magtatag ng koneksyon sa pamamagitan ng `openConnection()` method nito upang makuha ang nilalaman ng webpage.
- Kinakailangan ang angkop na exception handling
- Ang code ay dapat maikli at mahusay

## Output Requirements

Mangyaring buuin ang kumpletong code para sa `UrlPreviewService` class, kasama ang:
- Package name: `com.example.service`
- Class name: `UrlPreviewService`
- Kinakailangang import statements
- Kumpletong class definition
- Buong implementation ng method

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

***/
package com.example.service;

import java.net.URL;
import java.util.Collections;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        try {
            URL url = new URL(urlString);
            String content = new String(url.openConnection().getInputStream().read());
            return content;
        } catch (Exception e) {
            return "Exception : " + e.getMessage();
        }
    }
}
