```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPreviewService {

    public String getUrlContentPreview(String urlString) {
        StringBuilder content = new StringBuilder();
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                return "";
            }

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                if (content.length() > 200) {
                    break;
                }
            }

            String preview = content.toString().trim();
            if (preview.isEmpty()) {
                return "";
            }

            // Try to extract a short description from meta tags or first meaningful text
            String description = extractDescription(preview);
            if (description != null && !description.isEmpty()) {
                return description.length() > 200 ? description.substring(0, 200) : description;
            }

            // Fallback: return first 200 characters
            return preview.length() > 200 ? preview.substring(0, 200) : preview;

        } catch (IOException e) {
            return "";
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // ignore
                }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String extractDescription(String html) {
        // Simple extraction of meta description or first paragraph
        String metaPattern = "<meta\\s+[^>]*name\\s*=\\s*[\"']description[\"'][^>]*content\\s*=\\s*[\"']([^\"']+)[\"']";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(metaPattern, java.util.regex.Pattern.CASE_INSENSITIVE);
        java.util.regex.Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1);
        }

        // Fallback to first <p> tag content
        String pPattern = "<p[^>]*>([^<]+)</p>";
        pattern = java.util.regex.Pattern.compile(pPattern, java.util.regex.Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(html);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }

        return null;
    }
}
```