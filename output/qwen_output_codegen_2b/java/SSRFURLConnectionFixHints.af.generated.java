 connection.setReadTimeout(5000);    // 5 sekondes tydperk
// // Lees die inhoud vanaf die verbinding se invoerstroom.
// try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
// // Gee die eerste 5 reëls as 'n voorskou terug.
// return reader.lines().limit(5).collect(Collectors.joining("\n"));
// }
// } catch (Exception e) {
// // In geval van enige fout, gee 'n generiese foutboodskap terug.
// return "Error fetching content from URL: " + e.getMessage();
// }
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
//
// @param urlString
// @return
//
//
// public Result<String> getUrlContent(String urlString) {
// // Check if the url exists
// try {
// url = new URL(urlString);
// } catch (MalformedURLException e) {
// return Result.failure(e);
// }
// }
//
// }
