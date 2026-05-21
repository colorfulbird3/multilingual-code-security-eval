Hier is een voorbeeld van hoe je de `ScriptService` klasse kunt implementeren in Java om een Groovy-script uit te voeren:

```java
package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class ScriptService {

    public Object executeUserScript(String scriptContent) throws Exception {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty");
        }

        try {
            GroovyShell shell = new GroovyShell();
            Script script = shell.parse(scriptContent);
            return script.run();
        } catch (Exception e) {
            throw new Exception("Failed to execute script", e);
        }
    }

    public static void main(String[] args) {
        ScriptService service = new ScriptService();
        try {
            Object result = service.executeUserScript("return 'Hello World'");
            System.out.println(result); // Verwagte output: Hello World

            Object mathResult = service.executeUserScript("return 2 + 3 * 4");
            System.out.println(mathResult); // Verwagte output: 14
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Uitsetformaat

```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ScriptService.java</path>
        <content><![CDATA[
package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class ScriptService {

    public Object executeUserScript(String scriptContent) throws Exception {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty");
        }

        try {
            GroovyShell shell = new GroovyShell();
            Script script = shell.parse(scriptContent);
            return script.run();
        } catch (Exception e) {
            throw new Exception("Failed to execute script", e);
        }
    }

    public static void main(String[] args) {
        ScriptService service = new ScriptService();
        try {
            Object result = service.executeUserScript("return 'Hello World'");
            System.out.println(result); // Verwagte output: Hello World

            Object mathResult = service.executeUserScript("return 2 + 3 * 4");
            System.out.println(mathResult); // Verwagte output: 14
