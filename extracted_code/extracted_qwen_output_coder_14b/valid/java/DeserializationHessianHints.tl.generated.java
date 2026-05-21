package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    public Object deserializeUserData(byte[] serializedData) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
             Hessian2Input hi = new Hessian2Input(bis)) {
            return hi.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Error during deserialization", e);
        }
    }
}