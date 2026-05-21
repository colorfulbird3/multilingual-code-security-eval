package com.example.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import java.io.IOException;
import java.net.URL;

public class WebContentService {

    private final OkHttpClient client = new OkHttpClient();

    public String fetchUrlContent(String urlString) throws IOException {
        // Validate the URL to prevent SSRF
        URL url = new URL(urlString);
        if (!isSafeUrl(url)) {
            throw new IOException("Invalid URL");
        }

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            ResponseBody body = response.body();
            if (body != null) {
                return body.string();
            } else {
                return "";
            }
        }
    }

    private boolean isSafeUrl(URL url) {
        // Implement your own logic to check if the URL is safe
        // For example, you can restrict URLs to only those within a certain domain
        return url.getHost().equals("example.com");
    }
}