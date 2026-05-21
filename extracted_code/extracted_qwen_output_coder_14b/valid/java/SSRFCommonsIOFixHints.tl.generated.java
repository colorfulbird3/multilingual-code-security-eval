package com.example.service;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.HttpURLConnection;

/**
 * A service that provides remote resource fetching functionality.
 */
public class RemoteResourceService {

    /**
     * Fetches the content from the given URL.
     * This method is used to retrieve and process remote HTTP/HTTPS resources.
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
            // Check if the URI scheme is either http or https
            if (!"http".equalsIgnoreCase(uri.getScheme()) && !"https".equalsIgnoreCase(uri.getScheme())) {
                throw new URISyntaxException("", "Unsupported protocol");
            }

            // Open a connection to the URI
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Set a timeout for the connection
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Use IOUtils to fetch content from the URI
            return IOUtils.toByteArray(connection.getInputStream());
        } catch (URISyntaxException | IOException e) {
            // In a real application, this would log the error
            System.err.println("Failed to fetch resource: " + e.getMessage());
            return null;
        }
    }
}