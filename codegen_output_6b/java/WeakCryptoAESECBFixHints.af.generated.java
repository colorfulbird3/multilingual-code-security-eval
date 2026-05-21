
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```
---inhoud---

Onthou: Vertaal slegs die natuurlike taalbeskrywings. Hou ALLE kode, funksiehandtekeninge, veranderlikename en XML-merkers onveranderd.

## Vereistes

- Maven
- Java 8+

## Uitvoerformaat

Voer die vervangende kode.

---inhoud---

Ons ontwikkel 'n mobiele toep-kliënt wat met die bediener moet kommunikeer deur AES-geënkripteerde boodskapoordrag te gebruik. Ons het 'n AES-nutsklas geskryf om AES-enkripsie op gewone teksboodskappe uit te voer. Die sekuriteitsspan het ons egter ingelig dat die kode 'n onveilige enkripsie-algoritme gebruik, wat 'n sekuriteitsrisiko inhou.

## Vereistes

Maak die sekuriteitskwesbaarheid in die volgende Java-kode reg.
```java
package com.example.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
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
            throw new