package com.example.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageService {

    /**
     * Processes an image from a given URL.
     *
     * @param imageUrl The URL of the image to process.
     * @return true if the image is successfully processed, false otherwise.
     */
    public boolean processImageFromUrl(String imageUrl) {
        try {
            // Create a URL object from the provided imageUrl
            URL url = new URL(imageUrl);
            
            // Read the image data from the URL
            BufferedImage image = ImageIO.read(url);
            
            // Check if the image was successfully read
            if (image != null) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            // Handle any IOExceptions that may occur during the process
            e.printStackTrace();
            return false;
        }
    }
}