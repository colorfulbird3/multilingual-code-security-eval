package com.example.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public boolean writeFileContent(String filePath, String content) {
        try {
            // Maak 'n File-objekt aan met die gegee pad
            File file = new File(filePath);

            // Skep die lêer as dit nie bestaan nie
            if (!file.exists()) {
                file.createNewFile();
            }

            // Skryf die inhoud na die lêer
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();

            return true; // Suksesvolle skryfoperasie
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Mislukte skryfoperasie
        }
    }
}