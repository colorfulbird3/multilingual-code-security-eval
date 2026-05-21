```java
public class YAMLParser {
    public static void main(String[] args) {
        String yamlInput = "name: John\nage: 30\n";
        // Vulnerable: Directly parsing YAML without validation
        Object result = new Yaml().load(yamlInput);
        System.out.println(result);
    }
}
```