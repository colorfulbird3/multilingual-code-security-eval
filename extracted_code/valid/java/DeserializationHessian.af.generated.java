package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    /**
     * Deserializes user data from Hessian2 format.
     *
     * @param serializedData the byte array containing the serialized data
     * @return the deserialized object
     * @throws IOException if an I/O error occurs during deserialization
     */
    public Object deserializeUserData(byte[] serializedData) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
             Hessian2Input h2i = new Hessian2Input(bais)) {
            return h2i.readObject();
        }
    }
}