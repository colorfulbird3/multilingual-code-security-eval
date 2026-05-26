```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ScriptService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class ScriptService {

    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty");
        }

        try {
            Binding binding = new Binding();
            GroovyShell shell = new GroovyShell(binding);
            Script script = shell.parse(scriptContent);
            return script.run();
        } catch (Exception e) {
            throw new RuntimeException("Error executing script: " + e.getMessage(), e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```