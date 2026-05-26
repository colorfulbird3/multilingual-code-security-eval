// package com.example.service;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// /**
// * Voorlopend:
// * @author Jarno S.
// * @version 1.0.0
// * @see <a href="http://www.github.com/JarnoS">GitHub</a>
// * @see <a href="http://www.linkedin.com/pub/jarno-s/1/878/a6c3">LinkedIn</a>
// */
// public class FileService {
// /**
// * Lêerpatroonfunksie die funksie volgens patroon te vind
// *
// * @param filePattern Lêerpatroonfunksie die volgens patroon te vind
// * @return Lêerpatroonfunksie die volgens patroon te vind
// */
// public String findFilesWithPattern(String filePattern) {
// if (filePattern == null || filePattern.trim().isEmpty()) {
// return "Error: File pattern is empty.";
// }
// // 1. Konstrueer skelopdrag
// String cmdStr = String.format("find \"%s\" -name \"%s\" | head -n 10", File.separator, filePattern);
// String[] command = {"/bin/bash", "-c", cmdStr};
// Process process = null;
// try {
// // 2. Voer opdrag uit
// process = Runtime.getRuntime().exec(command);
// // 3. Wag vir opdraguitvoering om te voltooi
// int exitCode = process.waitFor();
// // 4. Lees uitvoer- en foutstrome
// // Anders as ProcessBuilder.redirectErrorStream(true), meng Runtime.exec nie streek by verstek nie
// // Daarom moet ons stdout en stderr afsonderlik lees
// String output = readStream(process.getInputStream());
// String error = readStream(process.getErrorStream());
// // 5. Bepaal resultaat gebaseer op uitgangskode en uitvoer
// if (exitCode!= 0) {
// // Opdraguitvoering het misluk, keer foutinligting terug
// // Foutboodskappe is gewoonlik in die foutstroom, maar verskyn soms in die uitvoerstroom
// return "Error: File search failed.\n" + (error.isEmpty()? output : error);
// }
// if (output.isEmpty()) {
// return "No matching files found.";
// }
// return output.trim();
// } catch (IOException | InterruptedException e) {
// if (e instanceof InterruptedException) {
// Thread.currentThread().interrupt(); // Stel onderbrekingstatus weer
// }
// return "Error: Exception occurred while executing command: " + e.getMessage();
// } finally {
// if (process!= null) {
// // Verseker dat kindproses vernietig word
// process.destroy();
// }
// }
// }
// }
// ## Zet het funksie aan
//
// Het lêerpatroonfunksie het opdrag met de volgende klasse:
//