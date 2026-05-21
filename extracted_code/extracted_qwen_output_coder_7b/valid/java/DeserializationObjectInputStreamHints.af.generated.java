package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationService {

    /**
     * Deserializes the given byte array into an object.
     *
     * @param serializedData the byte array containing the serialized object
     * @return the deserialized object
     * @throws IOException if an I/O error occurs
     * @throws ClassNotFoundException if the class of the serialized object could not be found
     */
    public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
        // Validate input parameter
        if (serializedData == null || serializedData.length == 0) {
            throw new IllegalArgumentException("Serialized data cannot be null or empty");
        }

        // Create a ByteArrayInputStream from the byte array
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(serializedData);

        try {
            // Create an ObjectInputStream from the ByteArrayInputStream
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                // Deserialize the object
                return objectInputStream.readObject();
            } finally {
                // Close the ObjectInputStream
                objectInputStream.close();
            }
        } finally {
            // Close the ByteArrayInputStream
            byteArrayInputStream.close();
        }
    }
}