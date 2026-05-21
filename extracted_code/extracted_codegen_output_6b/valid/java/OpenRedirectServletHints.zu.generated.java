```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/RedirectService.java
        </path>
        <content>
package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectService {

    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirectUrl = request.getRequestURI();
        response.sendRedirect(redirectUrl);
    }
}
        </content>
    </code>
</result>
```