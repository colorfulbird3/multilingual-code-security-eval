package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * A service that provides remote resource fetching functionality.
 */
public class RemoteResourceService {

    /**
     * Retrieves the content from the given URL.
     * This method is used to fetch and process remote HTTP/HTTPS resources.
     *
     * @param resourceUrl The URL of the resource, e.g., "https://www.aliyun.com/robots.txt"
     * @return The byte array content of the resource. Returns null if an error occurs or the URL is invalid.
     */
    public byte[] getResourceContent(String resourceUrl) {
        if (resourceUrl == null || resourceUrl.trim().isEmpty()) {
            return null;
        }

        try {
            // Convert the string to a URI object
            URI uri = new URI(resourceUrl);

            // Open a connection to the URI
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.err.println("Failed to fetch resource: HTTP error code " + responseCode);
                return null;
            }

            // Use IOUtils to fetch content from the URL
            return IOUtils.toByteArray(url.openStream());
        } catch (URISyntaxException | IOException e) {
            // In a real application, this would log the error
            System.err.println("Failed to fetch resource: " + e.getMessage());
            return null;
        }
    }
}