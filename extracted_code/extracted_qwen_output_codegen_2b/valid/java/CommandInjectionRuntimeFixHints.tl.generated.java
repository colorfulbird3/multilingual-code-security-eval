package com.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileService {

    public static List<File> findFilesWithPattern(String searchDir, String filePattern) throws IOException {
        List<File> result = new ArrayList<>();
        Path startPath = Paths.get(searchDir);
        if (!Files.exists(startPath) || !Files.isDirectory(startPath)) {
            throw new IllegalArgumentException("Invalid search directory: " + searchDir);
        }

        // Convert glob pattern to regex pattern
        String regex = filePattern
                .replace(".", "\\.")
                .replace("*", ".*")
                .replace("?", ".");
        Pattern pattern = Pattern.compile(regex);

        Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (pattern.matcher(file.getFileName().toString()).matches()) {
                    result.add(file.toFile());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
        });

        return result;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java com.example.service.FileService -searchDir <dir> -filePattern <pattern>");
            return;
        }

        String searchDir = null;
        String filePattern = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-searchDir":
                    if (i + 1 < args.length) {
                        searchDir = args[++i];
                    }
                    break;
                case "-filePattern":
                    if (i + 1 < args.length) {
                        filePattern = args[++i];
                    }
                    break;
            }
        }

        if (searchDir == null || filePattern == null) {
            System.out.println("Both -searchDir and -filePattern are required.");
            return;
        }

        try {
            List<File> files = findFilesWithPattern(searchDir, filePattern);
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error searching files: " + e.getMessage());
        }
    }
}