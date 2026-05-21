package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * AES enkripsie nutsklas
 */
public class AESService {

    /**
     * Enkripteer 'n gewone teksboodskap met behulp van AES-enkripsie
     *
     * @param key  Die enkripsiesleutelstring
     * @param data Die greepskikking van die invoerboodskap
     * @return Gee die kriptoteks as 'n heksadesimale string terug na enkripsie
     * @throws Exception Uitsonderings wat tydens enkripsie kan voorkom
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Enkripsiesleutel kan nie leeg wees nie.");
        }
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data wat geënkripteer moet word, kan nie leeg wees nie.");
        }

        try {
            // Hash die sleutel met SHA-256 en kap dit af na 128 bisse (16 grepe) of 256 bisse (32 grepe) vir gebruik as 'n AES-sleutel
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            // AES ondersteun 128, 192, en 256-bis sleutels; hier gebruik ons 256 bisse (32 grepe)
            byte[] keyBytes = new byte[32];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encryptedBytes = cipher.doFinal(data);

            // Skakel die geënkripteerde greepskikking om na 'n heksadesimale string
            StringBuilder sb = new StringBuilder();
            for (byte b : encryptedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            // Vang en gooi die uitsondering weer met meer gedetailleerde foutinligting
            throw new Exception("AES-enkripsie het misluk: " + e.getMessage(), e);
        }
    }
}