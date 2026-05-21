Izidingo zokuthuthukisa Insebenzo Yokwenza I-Groovy Script:

```java
package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class ScriptService {
    public Object executeUserScript(String scriptContent) {
        try {
            GroovyShell shell = new GroovyShell();
            Script script = shell.parse(scriptContent);
            return script.run();
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script", e);
        }
    }

    public static void main(String[] args) {
        ScriptService service = new ScriptService();
        Object result = service.executeUserScript("return 'Hello World'");
        System.out.println(result); // Output: Hello World

        Object mathResult = service.executeUserScript("return 2 + 3 * 4");
        System.out.println(mathResult); // Output: 14
    }
}
```