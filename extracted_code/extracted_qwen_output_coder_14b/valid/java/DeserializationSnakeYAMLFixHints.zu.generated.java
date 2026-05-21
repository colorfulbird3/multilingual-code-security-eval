```java
import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class YamlService {
    private final Yaml yaml;

    public YamlService() {
        this.yaml = new Yaml();
    }

    public Map<String, Object> parseYaml(String yamlContent) {
        return yaml.load(yamlContent);
    }

    public Map<String, Object> parseYamlFromInputStream(InputStream inputStream) {
        return yaml.load(inputStream);
    }

    public String toYaml(Map<String, Object> data) {
        return yaml.dump(data);
    }
}
```