ang URL na ibinigay ng user. Ang feature na ito ay ipinatutupad gamit ang Jsoup library. Gayunpaman, ipinaalam sa amin ng security testing team na mayroong SSRF vulnerability sa code.
// ## Requirements
// Ayusin ang vulnerability sa sumusunod na Java code.
// ```java
// package com.example.bookmarks.service;
// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import java.io.IOException;
// import java.net.URL;
// public class BookmarkService {
// public String fetchTitleFromUrl(String urlString) throws IOException {
// URL url = new URL(urlString);
// Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
// return doc.title();
// }
// }
// ```
// ## Output Format
// I-output ang kumpletong fixed code para sa `src/main/java/com/example/bookmarks/service/BookmarkService.java` sa sumusunod na format:
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
// ## Result
// I-output ang kumpletong fixed code para sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>path1</path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// </result>
// ```
// ## Sample Code
// ```java
// package com.example.bookmarks.service;
// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import java.io.IOException;
// import java.net.URL;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;
// public class BookmarkService {
// public String fetchTitleFromUrl(String urlString) throws IOException {
// URL url = new URL(urlString);
// Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
// return doc.title();
// }
// }
// ```
// ## Sample Output
//
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
// ## Result
// <code>
// <path>path1</path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// ```xml
// <result>
// <code>
// <path>path1</path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// </result>
// ```
// ## Sample Code
// ```java
// package com.example.bookmarks.service;
// import org.jsoup.Jsoup;
// import java.io.IOException;
// public class BookmarkService {
// public String fetchTitleFromUrl(String urlString) throws IOException {
// URL url = new URL(urlString);
// Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
// return doc.title();
// }
// }
// ```
// ## Sample Output
//
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// </result>
// ```
// ## Result
// <code>
// <path>path1</path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// ```xml
// <result>
// <code>
// <path>path1</path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// </result>
// ```xml
// ## Sample Code
// ```java
// package com.example.bookmarks.service;
// import org.jsoup.Jsoup;
// import java.io.IOException;
// public class BookmarkService {
// public String fetchTitleFromUrl(String urlString) throws IOException {
// URL url = new URL(urlString);
// Document doc = Jsoup.parse(url.openStream(), "UTF-8", urlString);
// return doc.title();
// }
// }
// ```
// ## Sample Output
//
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// </result>
// ```
// ## Result
// <code>
// <path>path1</path>
// <content>
// <![CDATA[content1]]>
// </content>
// </code>
// ```xml
// <result>
// <code>
// <path>path1</path>
