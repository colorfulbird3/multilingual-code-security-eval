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