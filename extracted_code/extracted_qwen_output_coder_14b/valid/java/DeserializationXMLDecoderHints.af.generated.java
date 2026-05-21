package com.example.config.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.beans.XMLDecoder;

public class ConfigurationLoaderService {

    public Object loadConfiguration(String xmlData) {
        InputStream inputStream = new ByteArrayInputStream(xmlData.getBytes());
        try (XMLDecoder decoder = new XMLDecoder(inputStream)) {
            return decoder.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing XML configuration", e);
        }
    }
}