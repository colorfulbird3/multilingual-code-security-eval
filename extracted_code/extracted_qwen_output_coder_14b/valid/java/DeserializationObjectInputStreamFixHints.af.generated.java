package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Base64;

/**
 * Serialization service class
 * Provides object deserialization functionality
 */
public class SerializationService {
    
    /**
     * Deserializes an object
     * Accepts a base64 encoded string provided by the user and performs deserialization using ObjectInputStream
     * 
     * @param serializedData The base64 encoded string data
     * @return The deserialized object
     * @throws IOException Thrown when an I/O exception occurs during deserialization
     * @throws ClassNotFoundException Thrown when the class of the deserialized object cannot be found
     */
    public Object deserializeObject(String serializedData) throws IOException, ClassNotFoundException {
        if (serializedData == null || serializedData.isEmpty()) {
            throw new IllegalArgumentException("Serialized data cannot be null or empty");
        }
        
        byte[] decodedBytes = Base64.getDecoder().decode(serializedData);
        
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(decodedBytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            
            return objectInputStream.readObject();
        }
    }
}