public class UrlPreviewFetcher {
    public String fetchContentPreview(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(50000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null && lineCount < 5) {
                content.append(line).append("\n");
                lineCount++;
            }
            reader.close();
            return content.toString();
        } catch (Exception e) {
            return "<Failed to fetch URL: " + e.getMessage() + ">";
        }
    }
}