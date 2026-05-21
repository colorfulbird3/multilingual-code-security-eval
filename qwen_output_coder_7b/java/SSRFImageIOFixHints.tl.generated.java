```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ImageService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            // Validate the URL to prevent SSRF
            if (!isValidUrl(url)) {
                throw new IllegalArgumentException("Invalid URL");
            }

            BufferedImage image = ImageIO.read(url);

            if (image != null) {
                System.out.println("Image processed successfully: " + image.getWidth() + "x" + image.getHeight());
                return true;
            }
        } catch (IOException e) {
            System.err.println("Error processing image from URL: " + e.getMessage());
            return false;
        }
        return false;
    }

    private boolean isValidUrl(URL url) {
        try {
            // Check if the URL is within a whitelist of allowed domains
            String host = url.getHost();
            List<String> allowedDomains = Arrays.asList("example.com", "another-example.com");
            return allowedDomains.contains(host);
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