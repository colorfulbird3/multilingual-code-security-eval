Hier is die reggestelde Java-kode vir `src/main/java/com/example/service/RedirectService.java`:

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

/**
 * 'n Diens om gebruikersherleiding na spesifieke aksies te hanteer.
 * Dit word algemeen gebruik in aanmeldvloei of na vormindienings.
 */
public class RedirectService {

    /**
     * Lees 'n terugkeer-URL uit die versoek en herlei die gebruiker na daardie URL.
     *
     * @param request  Die inkomende HttpServletRequest, wat na verwagting 'n 'returnUrl'-parameter bevat.
     * @param response Die HttpServletResponse wat gebruik word om die herleiding uit te voer.
     * @throws IOException as 'n invoer- of uitsetuitsondering voorkom.
     */
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Kry die bestemmings-URL uit die versoekparameter.
        String returnUrl = request.getParameter("returnUrl");

        // 'n Null of leë returnUrl moet na die tuisblad herlei.
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }

        // Voeg hier 'n kontrole toe om Oop Herlei te voorkom.
        if (!isSafeRedirectUrl(returnUrl)) {
            throw new SecurityException("Oop Herlei kwesbaarheid: ongeldige URL");
        }

        // Herlei die gebruiker na die gespesifiseerde terugkeer-URL.
        response.sendRedirect(returnUrl);
    }

    /**
     * Kontroleer of die terugkeer-URL veilig is.
     *
     * @param url Die URL om te kontroleer.
     * @return True as die URL veilig is, anders False.
     */
    private boolean isSafeRedirectUrl(String url) {
        // Voeg hier jou kontroles toe om die URL veilig te maak.
        // Voorbeeld: kontroleer of die URL begin met die toegestane domein.
        return url.startsWith("http://example.com") || url.startsWith("https://example.com");
    }
}
]]>
        </content>
    </code>
</result>
```