.
// try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
// // Return the first 5 lines as a preview.
// return reader.lines().limit(5).collect(Collectors.joining("\n"));
// }
// } catch (Exception e) {
// // In case of any error, return a generic error message.
// return "Error fetching content from URL: " + e.getMessage();
// }
// }
// }
// ```
// ## Output Format
// Ilabas ang kumpletong fixed code para sa `src/main/java/com/example/service/UrlPreviewService.java` sa sumusunod na format:
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
// ## Sample Output
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Code Sample
// ```java
// package com.example.service;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.util.stream.Collectors;
//
// public class UrlPreviewService {
// /**
// * Fetches the content from the provided URL string and returns a summary.
// * The summary is the first few lines of the resource content.
// *
// * @param urlString The URL of the resource to fetch.
// * @return A string containing a preview of the content, or an error message if fetching fails.
// */
// public String getUrlContentPreview(String urlString) {
// URL url = new URL(urlString);
// HttpURLConnection connection = (HttpURLConnection) url.openConnection();
// connection.setRequestMethod("GET");
// connection.connect();
// int code = connection.getResponseCode();
// if (code!= 200) {
// return "Error fetching content from URL: " + code;
// }
// String content = connection.getResponseMessage();
// try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
// // Return the first 5 lines as a preview.
// return reader.lines().limit(5).collect(Collectors.joining("\n"));
// }
// }
// }
// ```
// ## Notes
// 1. A `code` can only have a value of `200`.
// 2. If a URL is malformed, the response code will be `500`.
// 3. In case of a network error, the response code will be `500`.
// 4. The response message can be anything, as long as the `code` was `200`.
// 5. The `content` element contains the first few lines of the resource content.
// 6. `code` will not contain a value other than `200`.
// 7. `content` will not contain a value other than `null`.
// 8. The `code` is not an error message.
// */
// public class UrlPreviewService {
// // # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #