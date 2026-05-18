Sure, here's the Java code for the `WebContentService` class that uses OkHttp to fetch the content of a given URL:

```java
package com.example.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WebContentService {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchUrlContent(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            return response.body().string();
        }
    }
}
```

### Explanation:
1. **Imports**: The necessary classes from OkHttp and Java I/O are imported.
2. **Class Definition**: The `WebContentService` class is defined with a private field `client` of type `OkHttpClient`.
3. **Constructor**: A constructor initializes the `OkHttpClient` instance.
4. **fetchUrlContent Method**:
   - A `Request` object is created with the provided URL.
   - The `newCall` method of `OkHttpClient` is used to create a call object.
   - The `execute` method of the call object is used to send the request and receive the response.
   - If the response is not successful, an `IOException` is thrown.
   - The body of the response is returned as a string.

### Usage Example:
To use this service, you can call the `fetchUrlContent` method with a URL string:

```java
public class Main {
    public static void main(String[] args) {
        WebContentService service = new WebContentService();
        try {
            String content = service.fetchUrlContent("https://www.example.com");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

This example demonstrates how to fetch the content of a web page using the `WebContentService` class.