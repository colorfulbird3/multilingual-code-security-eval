package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    public Object deserializeUserData(byte[] serializedData) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedData);
             Hessian2Input in = new Hessian2Input(bais)) {
            return in.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Failed to deserialize data", e);
        }
    }
}