```java
package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectService {

    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Isevisi yokuhambisa kabusha ekhasi eliyisiqongo
        String returnUrl = request.getParameter("returnUrl");
        
        if (returnUrl != null && !returnUrl.isEmpty()) {
            // Ukugcinenya ukuhambisa kabusha ekhasi eliyisiqongo
            response.sendRedirect(returnUrl);
        } else {
            // Ukubiza ukuthi ikhasi ikhombisa kabusha noma isebenzisa isebenziso esingathandekayo
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Return URL is missing or invalid.");
        }
    }
}
```

### Isigcino

1. **Isisebenziso**: Sebenzisa `HttpServletRequest` kufikele ukuba ikhasi eliyisiqongo igcineneyo kabusha.
2. **Ukuhambisa Kabusha**: Ukuba ikhasi eliyisiqongo igcineneyo kabusha, `HttpServletResponse#sendRedirect` ukuhambisa kabusha ukuthi umsebenzisi ukuqonda kabusha ekhasi eliyisiqongo.
3. **Ukuqonda Ukuthi Ikhasi Ikhombisa Kabusha**: Ukuba ikhasi eliyisiqongo isengathandekayo noma isebenzisa isebenziso esingathandekayo, `HttpServletResponse#sendError` ukuqonda ukuthi ikhasi ikhombisa kabusha.

### Ikhasi Yokuqondiswa

- **Path**: `src/main/java/com/example/service/RedirectService.java`
- **Gama lephakheji**: `com.example.service`
- **Gama lekilasi**: `RedirectService`
- **Isiginesha yendlela**: `public void performRedirect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException`
- **Umqondo oyinhloko**: Sebenzisa `javax.servlet.http.HttpServletResponse#sendRedirect` ukwenza ukuhambisa kabusha.

### Ikhodi Yokuqondiswa

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
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Return URL is missing or invalid.");
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```