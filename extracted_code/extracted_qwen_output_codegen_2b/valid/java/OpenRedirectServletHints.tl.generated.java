package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectService {
    public void performRedirect(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException {
        response.sendRedirect("/homepage/home");
    }
}