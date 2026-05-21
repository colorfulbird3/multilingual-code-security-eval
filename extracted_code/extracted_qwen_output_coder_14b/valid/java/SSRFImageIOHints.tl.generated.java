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
            return image != null; // If ImageIO.read returns null, it means the image could not be read
        } catch (IOException e) {
            // Handle exceptions such as invalid URL, network issues, or unsupported image format
            return false;
        }
    }
}