package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    /**
     * Deserializes user data from a byte array using Hessian2.
     *
     * @param serializedData The byte array containing the serialized data.
     * @return The deserialized object.
     * @throws IOException If an I/O error occurs during deserialization.
     */
    public Object deserializeUserData(byte[] serializedData) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
             Hessian2Input in = new Hessian2Input(bais)) {
            return in.readObject();
        }
    }
}