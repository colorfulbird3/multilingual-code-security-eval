package com.example.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        try {
            // Maak 'n URL-objek van die URL-string
            URL url = new URL(imageUrl);
            
            // Aflaai en lees die beeld vanaf die URL
            BufferedImage image = ImageIO.read(url);
            
            // Indien die beeld suksesvol gelees kan word, is dit 'n geldige beeld
            return image != null;
        } catch (IOException e) {
            // Enige IO-uitsondering beteken dat die beeld nie korrekt kan word gelees nie
            return false;
        }
    }
}