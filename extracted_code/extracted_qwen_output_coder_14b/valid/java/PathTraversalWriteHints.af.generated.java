package com.example.service;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public boolean writeFileContent(String filePath, String content) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}