```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ScriptService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.MissingMethodException;

public class ScriptService {

    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty");
        }

        try {
            GroovyShell shell = new GroovyShell();
            Object result = shell.evaluate(scriptContent);
            return result;
        } catch (MissingMethodException e) {
            throw new RuntimeException("Method not found in the script", e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred during script execution", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```