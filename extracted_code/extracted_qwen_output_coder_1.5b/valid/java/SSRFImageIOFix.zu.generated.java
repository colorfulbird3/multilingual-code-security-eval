package com.example.service;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageProcessor {
        public boolean processImage(String imageUrl) {
            try {
                URL url = new URL(imageUrl);
                BufferedImage image = ImageIO.read(url);
                if (image == null) {
                    System.out.println("Image loaded successfully");
                    System.out.println("Image dimensions: " + image.getWidth() + " x " + image.getHeight());
                    return true;
                }
            } catch (IOException e) {
                System.err.println("Failed to process: " + imageUrl);
                System.err.println(e.getMessage());
                return false;
            }
            return false;
        }
}