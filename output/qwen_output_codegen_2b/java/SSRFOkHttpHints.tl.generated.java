 IOException`
// - Implementation requirement: Mangyaring gumamit ng `okhttp3.OkHttpClient` instance upang lumikha at mag-execute ng request. Partikular, ihanda ang network call sa pamamagitan ng pag-invoke ng `newCall(request)` method.
// - Kinakailangan ang naaangkop na exception handling
// - Ang code ay dapat maging concise at efficient
// - Walang security vulnerabilities
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/WebContentService.java` sa sumusunod na format:
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
// ## Solution
// # 1. Implement the `fetchUrlContent(String url)` method.
// # 2. Implement `java.net.URLConnection`
// # 3. Implement `okhttp3.OkHttpClient`
// # 4. Implement `java.net.URL`

public class WebContentService {
    public String fetchUrlContent(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
               .url(url)
               .build();
        return client.newCall(request).execute().body().string();
    }
}
