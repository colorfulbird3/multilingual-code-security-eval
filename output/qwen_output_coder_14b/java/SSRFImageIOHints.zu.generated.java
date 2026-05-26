```java
package com.example.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageService {
    public boolean processImageFromUrl(String imageUrl) {
        try {
            // Read the image from the URL
            BufferedImage image = ImageIO.read(new URL(imageUrl));
            
            // Check if the image is successfully loaded
            if (image != null) {
                System.out.println("Image loaded successfully.");
                return true;
            } else {
                System.out.println("Failed to load image.");
                return false;
            }
        } catch (IOException e) {
            // Handle exceptions that occur during image processing
            System.out.println("An error occurred while processing the image: " + e.getMessage());
            return false;
        }
    }
}
```

### Explanation:
- **Package Declaration**: The package declaration specifies the package name where the class is located.
- **Class Declaration**: The class `ImageService` contains the method `processImageFromUrl`.
- **Method Declaration**: The method `processImageFromUrl` takes a `String` parameter `imageUrl` which represents the URL of the image.
- **Try-Catch Block**: This block is used to handle potential `IOExceptions` that might occur during the image processing.
- **Image Reading**: The `ImageIO.read` method is used to read the image from the provided URL.
- **Null Check**: After reading the image, a check is performed to ensure the image was successfully loaded.
- **Return Values**: The method returns `true` if the image is loaded successfully, otherwise it returns `false`.
- **Exception Handling**: If an exception occurs, it prints an error message and returns `false`.

This code provides a basic implementation for loading an image from a URL and checking if it was successful. It can be further extended with additional functionality as needed.