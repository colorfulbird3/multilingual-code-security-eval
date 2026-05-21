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

    private final HttpClient httpClient = HttpClient.newHttpClient();

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

            // Create an HttpRequest to fetch content from the URI
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();

            // Use HttpClient to send the request and get the response
            HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

            // Check if the response status code is OK (200)
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Failed to fetch resource: Received status code " + response.statusCode());
                return null;
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // In a real application, this would log the error
            System.err.println("Failed to fetch resource: " + e.getMessage());
            return null;
        }
    }
}