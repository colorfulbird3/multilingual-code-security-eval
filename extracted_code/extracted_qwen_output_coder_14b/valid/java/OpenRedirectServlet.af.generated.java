package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectService {

    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Onderruk die waarde van die 'returnUrl' parameter uit die versoek
        String returnUrl = request.getParameter("returnUrl");

        // Kontroleer of die 'returnUrl' parameter bestaan
        if (returnUrl == null || returnUrl.isEmpty()) {
            // Indien die parameter ontbrek of leeg is, herlei na 'n standaardteikenblad
            response.sendRedirect("/default-dashboard");
        } else {
            // Herlei na die gespesifiseerde URL
            response.sendRedirect(returnUrl);
        }
    }
}