 content from URL: " + e.getMessage();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```
 */
public class UrlPreviewService {
    public String getUrlContentPreview(String urlString) {
        try {
            // Skep 'n URL-objek vanaf die gebruiker-verskafde string.
            URL url = new URL(urlString);

            // Maak 'n verbinding na die gespesifiseerde URL oop.
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000); // 5 sekondes tydperk
            connection.setReadTimeout(5000);    // 5 sekondes tydperk

            // Lees die inhoud vanaf die verbinding se invoerstroom.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                // Gee die eerste 5 reëls as 'n voorskou terug.
                return reader.lines().limit(5).collect(Collectors.joining("\n"));
            }
        } catch (Exception e) {
            // In geval van enige fout, gee 'n generiese foutboodskap terug.
            return "Error fetching content from URL: " + e.getMessage();
        }
    }
}
