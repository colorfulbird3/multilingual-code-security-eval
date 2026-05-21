```java
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;

public class HttpClientExample {
    public static void main(String[] args) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("http://example.com");
            HttpResponse response = httpClient.execute(request);
            String content = EntityUtils.toString(response.getEntity());
            System.out.println(content);
        }
    }
}
```