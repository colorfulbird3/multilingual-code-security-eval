package com.example.service;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

            // Use HttpClient to fetch content from the URI
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();

            HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Failed to fetch resource: HTTP status code " + response.statusCode());
                return null;
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // In a real application, this would log the error
            System.err.println("Failed to fetch resource: " + e.getMessage());
            return null;
        }
    }
}