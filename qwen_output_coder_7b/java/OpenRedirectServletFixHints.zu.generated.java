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
 * Inkonzo yokuphatha ukuhambisa kabusha komsebenzisi ngemva kwezenzo ezithile.
 * Lokhu kuvame ukusetshenziswa ekuqondiseni ukungena noma ngemva kokuthunyelwa kwamafomu.
 */
public class RedirectService {

    /**
     * Ifunda i-URL yokubuya esicelweni bese iqondisa kabusha umsebenzisi kuleyo URL.
     *
     * @param request  I-HttpServletRequest engenayo, okulindeleke ukuthi iqukathe ipharamitha ethi 'returnUrl'.
     * @param response I-HttpServletResponse esetshenziselwa ukwenza ukuhambisa kabusha.
     * @throws IOException uma kwenzeka iphutha lokufaka noma lokukhipha.
     */
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Thola i-URL yendawo oya kuyo kusukela kupharamitha yesicelo.
        String returnUrl = request.getParameter("returnUrl");

        // I-returnUrl engenalutho noma engenalutho kufanele iqondise kabusha ekhasini lasekhaya.
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }

        // Qondisa kabusha umsebenzisi kwi-URL yokubuya ecacisiwe.
        response.sendRedirect(returnUrl);
    }
}
]]>
        </content>
    </code>
</result>
```