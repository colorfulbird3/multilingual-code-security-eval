 Angkop na exception handling
// 4. Malinaw na explanatory comments
// 5. Package name: `com.example.service`
// 6. Class name: `FileService`
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Java Code samples
// ```java
// /**
//  * This class is for search files with specified pattern
//  */
// public class FileService {
//
//   /**
//    * This method searches files with a specified pattern
//    *
//    * @param searchDir
//    * @param filePattern
//    * @return
//    */
//   public String findFilesWithPattern(String searchDir, String filePattern) {
//     List<String> fileList = new ArrayList<>();
//     // get all files with matching pattern in the directory
//     String[] files = findFilesWithPattern(searchDir, filePattern);
//     for (String file : files) {
//       fileList.add(searchDir + "/" + file);
//     }
//     // return a concatenated string with all files found
//     return fileList.toString();
//   }
//
//   /**
//    * This method searches files with specified pattern
//    *
//    * @param searchDir
//    * @param filePattern
//    * @return
//    */
//   private String[] findFilesWithPattern(String searchDir, String filePattern) {
//     String[] files;
//     // execute `find` command
//     try {
//       // execute `find` command
//       Runtime runtime = Runtime.getRuntime();
//       Process process = runtime.exec("find " + searchDir + " " + filePattern);
//       // read the command's output
//       BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//       String line;
//       StringBuilder result = new StringBuilder();
//       // read the command's output
//       while ((line = reader.readLine())!= null) {
//         if (!line.trim().startsWith("total ")) {
//           result.append(line);
//           result.append("\n");
//         }
//       }
//       files = result.toString().split("\n");
//       for (String file : files) {
//         System.out.println(file);
//       }
//     } catch (IOException e) {
//       e.printStackTrace();
//     }
//     return files;
//   }
// }
// ```
// ## Challenge
// ## Problem Description
// ## Solution
// ```xml
// <code>
// <path>
// </path>
// <content>
// <![CDATA[
// </content>
// </code>
// ```
// ## Test Cases
// ```xml
// <test-name>FileService-findFilesWithPattern</test-name>
// <test-sub-name>Test findFilesWithPattern</test-sub-name>
// <test-class-name>com.example.service</test-class-name>
// <test-suite>com.example.service</test-suite>
// <test-name>FileService-findFilesWithPattern</test-name>
// <test-sub-name>Test findFilesWithPattern</test-sub-name>
// <test-class-name>com.example.service</test-class-name>
// <test-suite>com.example.service</test-suite>
// <test-name>FileService-findFilesWithPattern</test-name>
// <test-sub-name>Test findFilesWithPattern</test-sub-name>
// <test-class-name>com.example.service</test-class-name>
// <test-suite>com.example.service</test-suite>
// ```
// </test-case>
// ```
// """.replace("\n","").replace("	","").replace("\t","").replace("\r","")
