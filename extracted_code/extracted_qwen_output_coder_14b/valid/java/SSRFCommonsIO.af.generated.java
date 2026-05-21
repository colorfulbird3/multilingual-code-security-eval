package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.net.URL;
import java.io.IOException;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try {
            URL url = new URL(resourceUrl);
            InputStream inputStream = url.openStream();
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to retrieve resource content", e);
        }
    }
}