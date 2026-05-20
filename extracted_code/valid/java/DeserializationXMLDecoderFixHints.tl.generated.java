package com.example.config.service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Service for loading application configurations.
 * This service provides methods to interpret and load configuration data.
 */
public class ConfigurationLoaderService {

    /**
     * Loads an object configuration from an XML string.
     * The method deserializes the XML content into a Java object.
     *
     * @param xmlData A string containing the XML representation of the configuration object.
     * @return The deserialized configuration object.
     */
    public Object loadConfiguration(String xmlData) {
        try {
            // Encrypt the XML data before deserializing
            String encryptedXmlData = encrypt(xmlData);
            // Create a decoder to read the object from the encrypted XML stream.
            XMLDecoder decoder = new XMLDecoder(
                new ByteArrayInputStream(encryptedXmlData.getBytes(StandardCharsets.UTF_8))
            );
            // Read and return the deserialized object.
            Object result = decoder.readObject();
            decoder.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    /**
     * Encrypts the given XML data using AES encryption.
     *
     * @param data The XML data to encrypt.
     * @return The encrypted XML data.
     */
    private String encrypt(String data) throws Exception {
        Key key = new SecretKeySpec("0123456789abcdef".getBytes(), "AES");
        IvParameterSpec iv = new IvParameterSpec("0123456789abcdef".getBytes());
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return new String(encryptedBytes, StandardCharsets.UTF_8);
    }
}