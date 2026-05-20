```java
public class YAMLParser {
    public static void main(String[] args) {
        String yamlInput = "key: value\nlist:\n  - item1\n  - item2";
        System.out.println("Parsing YAML: " + yamlInput);
        // Vulnerable: Directly parsing user input without validation
        parseYAML(yamlInput);
    }

    public static void parseYAML(String yaml) {
        // Simulated YAML parsing logic
        String[] lines = yaml.split("\n");
        for (String line : lines) {
            System.out.println("Line: " + line);
        }
    }
}
```