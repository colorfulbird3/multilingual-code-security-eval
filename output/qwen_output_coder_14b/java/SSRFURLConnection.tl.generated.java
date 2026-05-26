```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/UrlPreviewService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to retrieve content";
        }

        // Extract title and description
        String title = extractTitle(content.toString());
        String description = extractDescription(content.toString());

        if (description.isEmpty()) {
            description = content.substring(0, Math.min(content.length(), 200));
        }

        return "Title: " + title + "\nDescription: " + description;
    }

    private String extractTitle(String html) {
        int startIndex = html.indexOf("<title>") + 7;
        int endIndex = html.indexOf("</title>", startIndex);
        if (startIndex != -1 && endIndex != -1) {
            return html.substring(startIndex, endIndex);
        }
        return "No title found";
    }

    private String extractDescription(String html) {
        int startIndex = html.indexOf("<meta name=\"description\" content=\"") + 34;
        int endIndex = html.indexOf("\"", startIndex);
        if (startIndex != -1 && endIndex != -1) {
            return html.substring(startIndex, endIndex);
        }
        return "";
    }
}
]]>
        </content>
    </code>
</result>
```