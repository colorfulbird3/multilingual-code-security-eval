```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ImageService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        try {
            // Validate the URL to prevent SSRF attacks
            if (!isValidUrl(imageUrl)) {
                System.err.println("Invalid URL: " + imageUrl);
                return false;
            }

            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();

            // Check if the response code is OK (200)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedImage image = ImageIO.read(url);

                if (image != null) {
                    System.out.println("Image processed successfully: " + image.getWidth() + "x" + image.getHeight());
                    return true;
                }
            } else {
                System.err.println("Failed to retrieve image. Response code: " + responseCode);
            }
        } catch (IOException e) {
            System.err.println("Error processing image from URL: " + e.getMessage());
        }
        return false;
    }

    private boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            return url.getProtocol().equals("http") || url.getProtocol().equals("https");
        } catch (Exception e) {
            return false;
        }
    }
}
]]>
        </content>
    </code>
</result>
```