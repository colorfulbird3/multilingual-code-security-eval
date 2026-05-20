package com.example.service;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RemoteResourceService {

    /**
     * Retrieves the content of a remote resource as a byte array.
     *
     * @param resourceUrl The URL of the remote resource.
     * @return The content of the remote resource as a byte array.
     * @throws IOException If an I/O error occurs while accessing the resource.
     */
    public byte[] getResourceContent(String resourceUrl) throws IOException {
        try (InputStream inputStream = new URL(resourceUrl).openStream()) {
            return IOUtils.toByteArray(inputStream);
        }
    }
}