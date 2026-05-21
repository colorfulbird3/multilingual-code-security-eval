package com.example.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationService {

    public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
        if (serializedData == null || serializedData.length == 0) {
            throw new IllegalArgumentException("Serialized data cannot be null or empty");
        }

        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return ois.readObject();
        }
    }
}