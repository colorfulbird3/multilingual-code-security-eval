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