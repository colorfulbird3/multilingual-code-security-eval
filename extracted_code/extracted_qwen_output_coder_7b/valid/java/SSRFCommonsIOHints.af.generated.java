package com.example.service;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class RemoteResourceService {

    /**
     * Retrieves the content of a remote resource as a byte array.
     *
     * @param resourceUrl The URL of the remote resource.
     * @return The content of the remote resource as a byte array.
     * @throws IOException If an I/O error occurs.
     */
    public byte[] getResourceContent(String resourceUrl) throws IOException {
        URL url = new URL(resourceUrl);
        URLConnection connection = url.openConnection();
        return IOUtils.toByteArray(connection.getInputStream());
    }
}