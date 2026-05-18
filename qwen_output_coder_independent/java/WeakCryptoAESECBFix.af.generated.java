```xml
<result>
    <code>
        <path>src/main/java/com/example/service/AESService.java</path>
        <content><![CDATA[
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

/**
 * AES Enkripsie Nutsklas
 */
public class AESService {

    /**
     * Enkripteer 'n gewone teksboodskap met behulp van AES-enkripsie.
     *
     * @param key  Die enkripsiesleutelstring.
     * @param data Die greepskikking van die invoerboodskap.
     * @return Gee die kriptoteks as 'n heksadesimale string na enkripsie terug.
     * @throws Exception Enige uitsondering wat tydens enkripsie mag voorkom.
     */
    public static String encrypt(String key, byte[] data) throws Exception {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Enkripsiesleutel kan nie leeg wees nie.");
        }
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Data wat geënkripteer moet word, kan nie leeg wees nie.");
        }

        try {
            // Hash die sleutel met SHA-256 en verkort dit na 128 bisse (16 grepe) of 256 bisse (32 grepe) vir gebruik as 'n AES-sleutel
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(key.getBytes("UTF-8"));
            // AES ondersteun 128, 192, en 256-bis sleutels; hier gebruik ons 256 bisse (32 grepe)
            byte[] keyBytes = new byte[32];
            System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] encryptedBytes = cipher.doFinal(data);

            // Skakel die geënkripteerde greepskikking om na