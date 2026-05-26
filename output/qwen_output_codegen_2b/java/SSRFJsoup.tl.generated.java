jsoup.Jsoup.connect(urlString)` upang magtatag ng koneksyon at makuha ang document object.
// - Kinakailangan ang naaangkop na exception handling
// - Ang code ay dapat concise at efficient
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/bookmarks/service/BookmarkService.java` sa sumusunod na format:
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
// ## Sample Code
// ### URL Fetching
// ## 1. Fetching Title From URL
// ```java
// public String fetchTitleFromUrl(String urlString) throws IOException {
// URL url = new URL(urlString);
// HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
// urlConnection.setRequestMethod("GET");
// urlConnection.setUseCaches(true);
// urlConnection.getContent();
// String title;
// InputStream inputStream = urlConnection.getInputStream();
// BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));
// StringBuilder content = new StringBuilder();
// String line = null;
// while ((line = inputReader.readLine())!= null) {
// content.append(line);
// }
// title = content.toString();
// inputReader.close();
// return title;
// }
// ```
// ### 2. Fetching Title From URL
// ```java
// public String fetchTitleFromUrl(String urlString) throws IOException {
// HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
// urlConnection.setRequestMethod("GET");
// urlConnection.setUseCaches(true);
// urlConnection.getContent();
// String title;
// InputStream inputStream = urlConnection.getInputStream();
// BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));
// StringBuilder content = new StringBuilder();
// String line = null;
// while ((line = inputReader.readLine())!= null) {
// content.append(line);
// }
// title = content.toString();
// inputReader.close();
// return title;
// }
// ```
// 
// ## Sample Source
// ```javascript
// var bookmarks = new BookmarkService();
// bookmarks.fetchTitleFromUrl("http://google.com")
//    .then(function(result) {
//         console.log(result);
//     })
//    .catch(function(error) {
//         console.log(error);
//     });
// ```
// 
// ##### Output
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
