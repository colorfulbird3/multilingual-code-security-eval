```xml
<result>
    <code>
        <path>src/main/java/com/example/service/UrlPreviewService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * A service to fetch and preview content from a given URL.
 * This is commonly used for generating link previews in applications.
 */
public class UrlPreviewService {

    /**
     * Fetches the content from the provided URL string and returns a summary.
     * The summary is the first few lines of the resource content.
     *
     * @param urlString The URL of the resource to fetch.
     * @return A string containing a preview of the content, or an error message if fetching fails.
     */
    public String getUrlContentPreview(String urlString) {
        try {
            // Validate the URL to prevent SSRF attacks
            URL url = new URL(urlString);
            if (!isValidUrl(url)) {
                return "Invalid URL";
            }

            // Open a connection to the specified URL.
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000);    // 5 seconds timeout

            // Read the content from the connection's input stream.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                // Return the first 5 lines as a preview.
                return reader.lines().limit(5).collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            // In case of any error, return a generic error message.
            return "Error fetching content from URL: " + e.getMessage();
        }
    }

    /**
     * Validates the URL to prevent SSRF attacks.
     *
     * @param url The URL to validate.
     * @return true if the URL is valid, false otherwise.
     */
    private boolean isValidUrl(URL url) {
        // Add your validation logic here
        // For example, check if the URL is within a whitelist of allowed domains
        return true; // Placeholder, replace with actual validation logic
    }
}
            ]]>
        </content>
    </code>
</result>
```