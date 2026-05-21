package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HessianService {

    public Object deserializeUserData(byte[] serializedData) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
             Hessian2Input hessian2Input = new Hessian2Input(bis)) {
            return hessian2Input.readObject();
        } catch (IOException e) {
            // Hier kan u 'n loggers gebruik om die fout te log of 'n aangepaste uitsondering te werp
            e.printStackTrace();
            throw new RuntimeException("Deserialisering misluk", e);
        }
    }
}