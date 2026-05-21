```java
public class ReportService {
    public String extractMetric(String xmlContent, String metricName) {
        // Simple XML parsing logic to extract metric value
        String startTag = "<" + metricName + ">";
        String endTag = "</" + metricName + ">";
        int startIndex = xmlContent.indexOf(startTag);
        if (startIndex == -1) {
            return null;
        }
        int endIndex = xmlContent.indexOf(endTag, startIndex);
        if (endIndex == -1) {
            return null;
        }
        return xmlContent.substring(startIndex + startTag.length(), endIndex);
    }
}
```