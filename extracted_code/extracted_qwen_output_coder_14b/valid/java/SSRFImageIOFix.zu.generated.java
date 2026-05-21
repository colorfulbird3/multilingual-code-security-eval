public class ImageService {
    public void processImageFromUrl(String url) {
        try {
            BufferedImage image = ImageIO.read(new URL(url));
            if (image != null) {
                System.out.println("Image dimensions: " + image.getWidth() + "x" + image.getHeight());
            } else {
                System.out.println("Failed to read image from URL");
            }
        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }
}