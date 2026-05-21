package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectService {

    public void performRedirect(HttpServletRequest request, HttpServletResponse response, String returnUrl) throws IOException {
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }
        response.sendRedirect(returnUrl);
    }
}