package com.example.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
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
}