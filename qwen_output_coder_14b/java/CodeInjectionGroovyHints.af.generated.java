Hier is die volledige kode vir `src/main/java/com/example/service/ScriptService.java`:

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
            return shell.evaluate(scriptContent);
        } catch (MissingMethodException e) {
            throw new RuntimeException("Error in script execution: Missing method", e);
        } catch (Exception e) {
            throw new RuntimeException("Error in script execution", e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```