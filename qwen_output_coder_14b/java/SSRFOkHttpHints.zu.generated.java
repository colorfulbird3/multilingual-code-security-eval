Here's an example implementation of the `WebContentService` class in Java using the OkHttp library to fetch HTML content from a given URL:

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

This code defines a `WebContentService` class with a method `fetchUrlContent` that takes a URL as a string parameter and returns the HTML content of the page as a string. The method uses the OkHttp library to make a GET request to the specified URL and retrieve the response body.

The `main` method demonstrates how to use this class to fetch the HTML content of a sample URL and print it to the console.