package com.example.service;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) throws Exception {
        // Open a connection to the resource
        URL url = new URL(resourceUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Get the input stream from the connection
        try (InputStream inputStream = connection.getInputStream()) {
            // Read the input stream into a byte array
            return IOUtils.toByteArray(inputStream);
        }
    }

    public static void main(String[] args) {
        RemoteResourceService service = new RemoteResourceService();
        try {
            byte[] content = service.getResourceContent("http://example.com/resource");
            System.out.println("Resource content length: " + content.length + " bytes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}