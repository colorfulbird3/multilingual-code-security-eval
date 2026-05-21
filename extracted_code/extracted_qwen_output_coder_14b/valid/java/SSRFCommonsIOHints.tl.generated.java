package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.net.URL;
import java.io.IOException;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try (InputStream in = new URL(resourceUrl).openStream()) {
            return IOUtils.toByteArray(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch resource content", e);
        }
    }
}