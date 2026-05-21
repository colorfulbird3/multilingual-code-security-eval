package com.example.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageService {

    public boolean processImageFromUrl(String imageUrl) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(imageUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000); // 5 seconds timeout

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedImage image = ImageIO.read(connection.getInputStream());

                if (image != null) {
                    System.out.println("Image processed successfully: " + image.getWidth() + "x" + image.getHeight());
                    return true;
                }
            } else {
                System.err.println("Failed to download image. HTTP error code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            System.err.println("Error processing image from URL: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return false;
    }
}