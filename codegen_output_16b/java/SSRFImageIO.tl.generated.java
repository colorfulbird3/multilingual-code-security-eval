
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

> path1 - url of the original image
> content1 - the processed image

## Example ImageUrl

`http://www.gravatar.com/avatar/9f6f8b0ba6a3c7b69f2f9cf2d6f8c79?d=identicon&s=32`

## Example Implementation

```java
public class ImageService {
    public boolean processImageFromUrl(String imageUrl) {
        try {
            // read image
            BufferedImage img = ImageIO.read(new URL(imageUrl));

            // scale image
            BufferedImage scaledImg = scale(img, 64, 64);

            // write image
            ImageIO.write(scaledImg, "png", new File("output.png"));

            return true;
        } catch (Exception ex) {
            // log exception
            return false;
        }
    }

    private BufferedImage scale(BufferedImage img, int width, int height) {
        BufferedImage scaledImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // create a graphics object
        Graphics2D g = scaledImg.createGraphics();

        // scale the image and return
        g.drawImage(img, 0, 0, width, height, null);
        g.dispose();
        return scaledImg;
    }
}
```

## Sample API Request

`http://localhost:3000/processImageFromUrl?imageUrl=http://www.gravatar.com/avatar/9f6f8b0ba6a3c7b69f2f9cf2d6f8c79?d=identicon&s=32`

## Sample API Response

`<?xml version="1.0" encoding="UTF-8"?>
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>`

## References

- [Paging in REST](https://www.tutorialspoint.com