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
     * @param request  The incoming HttpServletRequest, expected to contain a 'returnUrl' parameter.
     * @param response The HttpServletResponse used to perform the redirection.
     * @throws IOException if an input or output exception occurs.
     */
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get the destination URL from the request parameter.
        String returnUrl = request.getParameter("returnUrl");

        // Validate the returnUrl to prevent open redirect attacks.
        if (returnUrl == null || returnUrl.trim().isEmpty() || !isValidUrl(returnUrl)) {
            response.sendRedirect("/");
            return;
        }

        // Redirect the user to the specified return URL.
        response.sendRedirect(returnUrl);
    }

    /**
     * Validates if the provided URL is safe to redirect to.
     *
     * @param url The URL to validate.
     * @return true if the URL is valid, false otherwise.
     */
    private boolean isValidUrl(String url) {
        try {
            // Create a URI object to validate the URL.
            new java.net.URI(url);
            // Check if the URL starts with a trusted domain.
            return url.startsWith("https://example.com") || url.startsWith("http://example.com");
        } catch (Exception e) {
            return false;
        }
    }
}