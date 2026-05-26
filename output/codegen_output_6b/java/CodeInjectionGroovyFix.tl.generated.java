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

## Programa

```java
public class ScriptService {
    public Object executeUserScript(String scriptContent) {
        GroovyShell shell = new GroovyShell();
        return shell.evaluate(scriptContent);
    }
}
```
