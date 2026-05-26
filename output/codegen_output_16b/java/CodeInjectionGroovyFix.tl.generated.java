ga kaso kung saan ang input ay empty string o null
- Mag-throw ng naaangkop na exception kapag nabigo ang pag-execute ng script
- Ang bersyon ng Groovy ay 3.0.9; huwag gumamit ng mga API na hindi suportado sa bersyong ito.

## Format ng Output

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/ScriptService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

Ang code ay isang elemento de <result>, dahil siya ay ayos ng mga resulta ng mga bersiyong script.

I-output ay isang elemento de <result>, dahil siya ay ayos ng mga output ng mga bersiyong script.

## Example

```groovy
// Example
package com.example.service;

import groovy.lang.GroovyShell;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class ScriptService {

    /**
     * Parses and executes the given Groovy script content.
     *
     * @param scriptContent A string containing the user-provided Groovy script content.
     * @return The execution result of the script, of type Object.
     * @throws IllegalArgumentException If the script content is null or empty.
     */
    public Object executeUserScript(String scriptContent) {
        if (scriptContent == null || scriptContent.trim().isEmpty()) {
            throw new IllegalArgumentException("Script content cannot be null or empty.");
        }

        GroovyShell shell = new GroovyShell();
        return shell.evaluate(scriptContent);
    }
}
```

## References

- http://stackoverflow.com/a/29078398/282281

"""
