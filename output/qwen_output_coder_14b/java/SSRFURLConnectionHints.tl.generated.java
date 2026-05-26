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
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlPreviewService {

    public String getUrlContentPreview(String urlString) {
        if (urlString == null || urlString.isEmpty()) {
            return "";
        }

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return "";
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            int bytesRead = 0;
            while ((inputLine = in.readLine()) != null && bytesRead < 1024) {
                content.append(inputLine);
                bytesRead += inputLine.length() + 1; // +1 for newline character
            }
            in.close();

            return content.toString();
        } catch (MalformedURLException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```