package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

/**
 * A service to handle user redirection after specific actions.
 * This is commonly used in login flows or after form submissions.
 */
public class RedirectService {

    /**
     * Reads a return URL from the request and redirects the user to that URL.
     *
     * @param request  The incoming HttpServletRequest, expected to contain a 'returnUrl' parameter.
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

        // Validate the return URL to prevent open redirect vulnerabilities.
        if (!isValidUrl(returnUrl)) {
            response.sendRedirect("/");
            return;
        }

        // Redirect the user to the specified return URL.
        response.sendRedirect(returnUrl);
    }

    /**
     * Validates the URL to ensure it is safe to redirect to.
     *
     * @param urlString The URL string to validate.
     * @return true if the URL is valid and safe, false otherwise.
     */
    private boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            // Only allow URLs with the same domain as the application.
            return "yourdomain.com".equals(url.getHost());
        } catch (Exception e) {
            return false;
        }
    }
}