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