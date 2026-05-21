package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    public Object deserializeUserData(byte[] serializedData) {
        if (serializedData == null) {
            throw new IllegalArgumentException("Serialized data cannot be null");
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
             Hessian2Input hessian2Input = new Hessian2Input(bis)) {
            return hessian2Input.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Error during deserialization", e);
        }
    }
}