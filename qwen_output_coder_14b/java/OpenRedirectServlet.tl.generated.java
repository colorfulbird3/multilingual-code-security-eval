```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/RedirectService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectService {

    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String returnUrl = request.getParameter("returnUrl");
        if (returnUrl != null && !returnUrl.isEmpty()) {
            response.sendRedirect(returnUrl);
        } else {
            // Default redirect URL if returnUrl is not provided or empty
            response.sendRedirect("/defaultPage");
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```