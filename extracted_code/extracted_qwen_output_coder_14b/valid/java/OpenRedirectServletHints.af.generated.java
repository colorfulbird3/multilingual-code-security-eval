package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectService {

    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Haal die 'returnUrl' parameter uit die versoek
        String returnUrl = request.getParameter("returnUrl");

        // Kontroleer of die 'returnUrl' parameter aanwezig is en nie null is
        if (returnUrl != null && !returnUrl.isEmpty()) {
            // Voer die herleiding uit na die gespesifiseerde URL
            response.sendRedirect(returnUrl);
        } else {
            // Indien die 'returnUrl' parameter ontbrek of leeg is, herlei na 'default.jsp'
            response.sendRedirect("default.jsp");
        }
    }
}