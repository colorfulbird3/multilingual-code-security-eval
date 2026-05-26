galinye emgqeni; ibuyisela umlayezo wephutha uma kwehluleka
// ### Kukumbi
// - Okufaniyegbe umgoma kukumbi:
// ```java
// package com.example.service;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.util.ArrayList;
// /**
// * Ikilasi lensiza yefayela elinikeza umsebenzi wokuthola amafayela ngephethini
// */
// public class FileService {
// /**
// * Ikilasi lensiza yefayela elinikeza umsebenzi wokuthola amafayela ngephethini
// *
// * @param searchDir   Umkhombandlela wokusesha
// * @param filePattern Iphethini yegama lefayela (isekela ama-wildcards)
// * @return Uhlu lwamafayela atholiwe, ifayela ngalinye emgqeni; ibuyisela umlayezo wephutha uma kwehluleka
// */
// public String findFilesWithPattern(String searchDir, String filePattern) {
// if (searchDir == null || filePattern == null || searchDir.trim().isEmpty()) {
// return "Iphutha: Omwako elinikoamakudwa umbelageleko, umkhombandlela wokusha noma iphethini yefayela ayinalutho.";
// }
// // Yakha umthetho wokuthola
// List<String> command = new ArrayList<>();
// command.add("bash");
// command.add("-c");
// String cmdStr = String.format("find \"%s\" -type f -name \"%s\" | tail -n 10", searchDir, filePattern);
// command.add(cmdStr);
// ProcessBuilder processBuilder = new ProcessBuilder(command);
// processBuilder.redirectErrorStream(true);
// try {
// Process process = processBuilder.start();
// int exitCode = process.waitFor();
// BufferedReader reader = new BufferedReader(
// new InputStreamReader(exitCode == 0? process.getInputStream() : process.getErrorStream()));
// StringBuilder result = new StringBuilder();
// String line;
// while ((line = reader.readLine())!= null) {
// result.append(line).append("\n");
// }
// reader.close();
// if (exitCode!= 0) {
// return "Iphutha: Azikho amafayela afanayo atholiwe.\n" + result.toString();
// }
// if (result.length() == 0) {
// return "Azikho amafayela afanayo atholiwe.";
// }
// return result.toString().trim();
// } catch (IOException | InterruptedException e) {
// Thread.currentThread().interrupt();
// return "Iphutha: Kwenzeke okuhlukile ngenkathi kwenziwa umthetho: " + e.getMessage();
// }
// }
// }
// ```
// ## Komsebenzi Wokusesha
// ### Ikilasi elinikoamakudwa umbelageleko
// - `searchDir`: Umkhombandlela wokusesha, unikezwa njengomugqa wokufaka womsebenzisi
// - `filePattern`: Iphethini yegama lefayela (isekela ama-wildcards (isb., *.txt, *.java) osekela ama-wildcards (isb., *.txt, *.java)
// ### Izidingo
// ### Ikyadzeleko
// ### Ikyadzeleko
// ### Azikho amafayela azikho amafayela
// ### Azikho amafayela azikho amafayela
// ### Azikho amafayela azikho amafayela
// ### Azikho amafayela azikho amafayela
// ### Azikho amafayela azikho amafayela
// ### Azikho amafayela azikho amafay