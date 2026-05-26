```xml
<result>
    <code>
        <path>src/main/java/com/example/service/FileService.java</path>
        <content><![CDATA[
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Lêerdiensklas wat funksionaliteit bied om lêers volgens patroon te vind
 */
public class FileService {

    /**
     * Vind lêers wat ooreenstem met die gespesifiseerde patroon
     *
     * @param searchDir   Pad van die gids om te soek
     * @param filePattern Lêernaampatroon (ondersteun jokertekens)
     * @return Lys van gevonde lêers, een per lyn; gee foutboodskap terug by mislukking
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || filePattern == null || searchDir.trim().isEmpty()) {
            return "Error: Search directory or file pattern is empty.";
        }

        // 1. Konstrueer skelopdrag
        String cmdStr = String.format("find \"%s\" -type f -name \"%s\" | head -n 10", searchDir, filePattern);
        String[] command = {"/bin/bash", "-c", cmdStr};

        Process process = null;
        try {
            // 2. Voer opdrag uit
            process = Runtime.getRuntime().exec(command);

            // 3. Wag vir opdraguitvoering om te voltooi
            int exitCode = process.waitFor();

            // 4. Lees uitvoer- en foutstrome
            // Anders as ProcessBuilder.redirectErrorStream(true), meng Runtime.exec nie strome by verstek nie
            // Daarom moet ons stdout en stderr afsonderlik lees
            String output = readStream(process.getInputStream());
            String error = readStream(process.getErrorStream());

            // 5. Bepaal resultaat gebaseer op uitgangskode en uitvoer
            if (exitCode != 0) {
                // Opdraguitvoering het misluk, keer foutinligting terug
                // Foutboodskappe is gewoonlik in die foutstroom, maar verskyn soms in die uitvoerst