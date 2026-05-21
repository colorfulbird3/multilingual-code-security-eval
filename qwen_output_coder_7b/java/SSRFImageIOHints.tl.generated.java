```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ImageService.java</path>
        <content><![CDATA[
package com.example.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            BufferedImage image = ImageIO.read(url);
            return image != null;
        } catch (IOException e) {
            return false;
        }
    }
}
]]></content>
    </code>
</result>
```