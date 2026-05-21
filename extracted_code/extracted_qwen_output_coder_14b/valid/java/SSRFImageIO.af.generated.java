package com.example.service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        try {
            // Maak 'n URL-objek van die gegee URL-string
            URL url = new URL(imageUrl);
            
            // Probeer om die beeld te lees van die URL
            BufferedImage image = ImageIO.read(url);
            
            // As die beeld suksesvol gelees word, return true
            if (image != null) {
                return true;
            }
        } catch (IOException e) {
            // Verwyder almalige IO-uitsonderings, return false
            e.printStackTrace();
        }
        
        // Indien enige ander probleme ontstaan, return false
        return false;
    }

}