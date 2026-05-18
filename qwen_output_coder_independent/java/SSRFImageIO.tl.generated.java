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
            if (image != null) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
]]></content>
    </code>
</result>
```