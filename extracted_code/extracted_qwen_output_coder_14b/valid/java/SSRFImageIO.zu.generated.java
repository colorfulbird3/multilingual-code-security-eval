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
            
            // Check if the image was successfully read
            if (image != null) {
                // The image was successfully processed
                return true;
            } else {
                // Image could not be read
                System.out.println("Failed to read the image.");
                return false;
            }
        } catch (IOException e) {
            // Handle exceptions that occur during image processing
            System.out.println("An error occurred while processing the image: " + e.getMessage());
            return false;
        }
    }
}