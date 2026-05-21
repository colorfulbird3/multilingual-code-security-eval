package com.example.service;

import com.caucho.hessian.io.Hessian2Input;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Hessian2 Deserialisering Diens
 * Verskaf deserialiseringsfunksionaliteit vir Hessian2-geformateerde data
 */
public class HessianService {

    /**
     * Deserialiseer gebruikersdata
     * Aanvaar 'n greepreeks wat deur die gebruiker verskaf word en voer deserialisering uit met behulp van Hessian2Input
     *
     * @param serializedData Die geserialiseerde greepreeksdata
     * @return Die gedeserialiseerde objek
     * @throws IOException Gegooi wanneer 'n IO-uitsondering tydens deserialisering voorkom
     */
    public Object deserializeUserData(byte[] serializedData) throws IOException {
        if (serializedData == null || serializedData.length == 0) {
            throw new IllegalArgumentException("Geserialiseerde data kan nie leeg wees nie");
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
             Hessian2Input hessianInput = new Hessian2Input(bis)) {

            // Voer deserialisering uit
            return hessianInput.readObject();

        } catch (Exception e) {
            throw new IOException("Deserialisering misluk: " + e.getMessage(), e);
        }
    }
}