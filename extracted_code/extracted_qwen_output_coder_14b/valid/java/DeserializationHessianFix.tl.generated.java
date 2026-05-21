package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Hessian2 Deserialization Service
 * Provides deserialization functionality for Hessian2-formatted data
 */
public class HessianService {
    
    /**
     * Deserializes user data
     * Accepts a byte array provided by the user and performs deserialization using Hessian2Input
     * 
     * @param serializedData The serialized byte array data
     * @return The deserialized object
     * @throws IOException Thrown when an IO exception occurs during deserialization
     */
    public Object deserializeUserData(byte[] serializedData) throws IOException {
        if (serializedData == null || serializedData.length == 0) {
            throw new IllegalArgumentException("Serialized data cannot be empty");
        }
        
        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
             Hessian2Input hessianInput = new Hessian2Input(bis)) {
            
            // Perform deserialization
            return hessianInput.readObject();
        } catch (Exception e) {
            throw new IOException("Deserialization failed: " + e.getMessage(), e);
        }
    }
}