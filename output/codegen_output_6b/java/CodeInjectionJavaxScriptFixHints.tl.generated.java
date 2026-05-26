>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Usage

```java
public class DynamicMetricService {

    public static void main(String[] args) {
        DynamicMetricService service = new DynamicMetricService();

        try {
            Map<String, Object> context = new HashMap<>();
            context.put("count", "123");
            context.put("name", "John Doe");
            context.put("address", "New York, NY");

            String formula = context.containsKey("address")? "count + name + address" : "count";

            Object value = service.calculate(formula, context);
            System.out.println(value);
        }
        catch (ScriptException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

## Dependencies

```java
- javax.script.ScriptEngineManager
- javax.script.ScriptEngine
```
