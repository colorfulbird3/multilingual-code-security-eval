package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Serialization service class
 * Provides object deserialization functionality
 */
public class SerializationService {
    
    /**
     * Deserializes an object
     * Accepts a byte array provided by the user and performs deserialization using ObjectInputStream
     * 
     * @param serializedData The serialized byte array data
     * @return The deserialized object
     * @throws IOException Thrown when an I/O exception occurs during deserialization
     * @throws ClassNotFoundException Thrown when the class of the deserialized object cannot be found
     */
    public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
        if (serializedData == null || serializedData.length == 0) {
            throw new IllegalArgumentException("Serialized data cannot be null or empty");
        }
        
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            
            // Check if the deserialized object is an instance of Serializable
            Object obj = objectInputStream.readObject();
            if (!(obj instanceof Serializable)) {
                throw new IllegalArgumentException("Deserialized object must implement Serializable interface");
            }
            
            return obj;
        }
    }
}