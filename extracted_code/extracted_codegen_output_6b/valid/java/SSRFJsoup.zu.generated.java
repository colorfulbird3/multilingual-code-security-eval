```java
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    public static void main(String[] args) {
        String url = "https://example.com"; // Replace with actual URL
        try {
            Document doc = Jsoup.connect(url).get();
            List<String> data = extractData(doc);
            data.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> extractData(Document doc) {
        List<String> result = new ArrayList<>();
        Elements elements = doc.select("div.content"); // Example selector
        for (Element element : elements) {
            result.add(element.text());
        }
        return result;
    }
}
```