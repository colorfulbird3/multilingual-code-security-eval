package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationService {

    /**
     * Deserializes an object from the given byte array.
     *
     * @param serializedData The byte array containing the serialized data.
     * @return The deserialized object.
     * @throws IOException if an I/O error occurs.
     * @throws ClassNotFoundException if the class of a serialized object could not be found.
     */
    public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
        if (serializedData == null || serializedData.length == 0) {
            throw new IllegalArgumentException("Serialized data cannot be null or empty");
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        }
    }
}