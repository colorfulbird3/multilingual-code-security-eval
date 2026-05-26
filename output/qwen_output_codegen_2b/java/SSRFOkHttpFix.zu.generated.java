Service {
// private final OkHttpClient client = new OkHttpClient();
// public String fetchUrlContent(String url) throws IOException {
// Request request = new Request.Builder()
//.url(url)
//.build();
// try (Response response = client.newCall(request).execute()) {
// if (!response.isSuccessful()) {
// throw new IOException("Unexpected code " + response);
// }
// ResponseBody body = response.body();
// if (body!= null) {
// return body.string();
// } else {
// return "";
// }
// }
// }
// }
// ```
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/WebContentService.java` ngefomethi elandelayo:
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
// ## Ifomethi Yama
// Yama ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/WebContentService.java` ngefomethi elandelayo:
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
/**
 * Created by ku_ra on 23/07/16.
 */
public class WebContentService {

    private static final String URL = "http://www.lungisa.com/";

    public String fetchUrlContent(String url) throws IOException {
        Request request = new Request.Builder()
               .url(url)
               .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            ResponseBody body = response.body();
            if (body!= null) {
                return body.string();
            } else {
                return "";
            }
        }
    }
}
