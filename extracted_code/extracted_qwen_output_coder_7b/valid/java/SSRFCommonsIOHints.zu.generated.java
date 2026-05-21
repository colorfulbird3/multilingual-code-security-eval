package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.net.URL;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try {
            URL url = new URL(resourceUrl);
            InputStream inputStream = url.openStream();
            return IOUtils.toByteArray(inputStream);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return null;
        }
    }
}