package com.example.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageService {

    private static final List<String> ALLOWED_DOMAINS = Arrays.asList(
        "example.com",
        "another-example.com"
    );

    public boolean processImageFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            String host = url.getHost();

            if (!ALLOWED_DOMAINS.contains(host)) {
                System.err.println("Host not allowed: " + host);
                return false;
            }

            BufferedImage image = ImageIO.read(url);

            if (image != null) {
                System.out.println("Image processed successfully: " + image.getWidth() + "x" + image.getHeight());
                return true;
            }
        } catch (MalformedURLException e) {
            System.err.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error processing image from URL: " + e.getMessage());
        }
        return false;
    }
}