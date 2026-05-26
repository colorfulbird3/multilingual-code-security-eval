Here's an example implementation of the `fetchUrlContent` method using Java and OkHttp library:

```java
package com.example.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WebContentService {

    public String fetchUrlContent(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            return response.body().string();
        }
    }

    public static void main(String[] args) {
        WebContentService service = new WebContentService();
        try {
            String htmlContent = service.fetchUrlContent("https://example.com");
            System.out.println(htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

This code defines a `WebContentService` class with a `fetchUrlContent` method that takes a URL as input and returns the HTML content of the page at that URL as a string. It uses the OkHttp library to make an HTTP GET request to the specified URL and read the response body.

The `main` method demonstrates how to use this service to fetch the HTML content of "https://example.com" and print it to the console. If there's an error during the process, it will be caught and printed to the console.

To use this code, you'll need to include the OkHttp library in your project. If you're using Maven, you can add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.0</version>
</dependency>
```

If you're using Gradle, add this to your `build.gradle` file:

```groovy
implementation 'com.squareup.okhttp3:okhttp:4.9.0'
```

Make sure to replace "https://example.com" with the actual URL you want to fetch the content from.