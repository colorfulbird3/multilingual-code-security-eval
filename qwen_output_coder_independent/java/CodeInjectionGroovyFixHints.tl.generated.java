```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ScriptService.java</path>
        <content><![CDATA[
package com.example.service;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * Groovy script execution service.
 * Provides functionality to execute Groovy script strings submitted by users.
 */
public class ScriptService {

    /**
     * Parses and executes the given Groovy script content.
     *
     * @param scriptContent A string containing the Groovy script content provided by the user.
     * @return The result of script execution, of type Object.
     * @throws IllegalArgumentException if the script content is null or empty.
     */
    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty.");
        }

        try {
            GroovyShell shell = new GroovyShell();
            Script script = shell.parse(scriptContent);
            return script.run();
        } catch (Exception e) {
            throw new RuntimeException("Error executing script", e);
        }
    }
}
]]></content>
    </code>
</result>
```