Exception`
- Core logic: Use the `javax.servlet.http.HttpServletResponse#sendRedirect` method to perform the redirect.
- Include appropriate exception handling
- Code should be concise and efficient
- No security vulnerabilities



## Output Format

Output the complete code for `src/main/java/com/example/service/RedirectService.java` in the following format:

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

**Explanation**

- `path` is a relative path of the file
- `content` is the content of the file.

## Note

- `content` is plain text. It will be automatically encoded in the browser.

## Sample Input

## Sample Output

```xml
<result>
    <code>
        <path>
            <value>/path1</value>
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```
"""

import re
from urllib.parse import urljoin

class RedirectService(object):
    def __init__(self):
        pass

    def performRedirect(self, request, response):
        if request.getMethod() == "GET":
            path = request.getPathInfo()
            url = request.getRequestURI()
            if not url.startswith("/") and not url.startswith("/"):
                url = "/" + url
            url = urljoin(request.getRequestURL().toString(), url)
            response.sendRedirect(url)
