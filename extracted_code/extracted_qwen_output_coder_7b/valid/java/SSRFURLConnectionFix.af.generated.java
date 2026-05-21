package com.example.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * A service to fetch content from a given URL string and return a preview.
 * This is commonly used for generating link previews in applications.
 */
public class UrlPreviewService {

    /**
     * Fetches the content of the provided URL string and returns a summary.
     * The summary consists of the first few lines of the resource content.
     *
     * @param urlString The URL of the resource to fetch.
     * @return A string containing a preview of the content, or an error message if fetching fails.
     */
    public String getUrlContentPreview(String urlString) {
        try {
            // Create a URL object from the user-provided string.
            URL url = new URL(urlString);

            // Open a connection to the specified URL.
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000);    // 5 seconds timeout

            // Read the content of the connection's input stream.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                // Return the first 5 lines as a preview.
                return reader.lines().limit(5).collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            // In case of any error, return a generic error message.
            return "Error fetching content from URL: " + e.getMessage();
        }
    }
}