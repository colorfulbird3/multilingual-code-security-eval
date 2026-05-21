```java
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPreviewServlet {

    public String getUrlContentPreview(String urlString) {
        StringBuilder content = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return "Error: HTTP response code " + responseCode;
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            int bytesRead = 0;
            int maxBytes = 1024; // 1KB limit

            while ((line = reader.readLine()) != null && bytesRead < maxBytes) {
                content.append(line);
                bytesRead += line.getBytes().length;
                if (bytesRead >= maxBytes) {
                    break;
                }
            }

            return content.toString();

        } catch (IOException e) {
            return "Error: " + e.getMessage();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (IOException e) {
                // Log or ignore
            }
        }
    }
}
```