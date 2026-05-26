

## Msebenzi ukulisa

Ukusile msebenzi ukulisa ekithathu elandeli:

```java
package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A service to handle user redirection after specific actions.
 * This is commonly used in login flows or after form submissions.
 */
public class RedirectService {

    /**
     * Reads a return URL from the request and redirects the user to that URL.
     *
     * @param request  The incoming HttpServletRequest, expected to contain a'returnUrl' parameter.
     * @param response The HttpServletResponse used to perform the redirection.
     * @throws IOException if an input or output exception occurs.
     */
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the destination URL from the request parameter.
        String returnUrl = request.getParameter("returnUrl");

        // A null or empty returnUrl should redirect to the homepage.
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }

        // Redirect the user to the specified return URL.
        response.sendRedirect(returnUrl);
    }
}
```