ImageIO#read` para basahin at i-parse ang image data mula sa URL.
- Isama ang naaangkop na exception handling
- Ang code ay dapat concise at efficient

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ImageService.java` sa sumusunod na format:

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

## Example

```java

package com.example.service;

import javax.imageio.ImageIO;

public class ImageService {
    public boolean processImageFromUrl(String imageUrl) {
        try {
            byte[] bytes = ImageIO.read(new URL(imageUrl));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
```

## References

[1] http://www.geeksforgeeks.org/checking-a-url-whether-it-is-valid/
[2] http://stackoverflow.com/questions/298880/how-do-you-validate-a-url-in-python
[3] http://stackoverflow.com/questions/10683715/python-how-to-check-if-a-url-is-valid
[4] https://tools.ietf.org/html/rfc2396
[5] http://www.geeksforgeeks.org/check-whether-an-url-is-valid-or-not/

## Refactoring

- Refactor processImageFromURL method.
- Refactor ito kasama ang `javax.imageio.ImageIO#read` para sa isang parengit sa pamamagitan ng `ImageIO` library.
