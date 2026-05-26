awak ng exception
- Ang code ay dapat maikli at mahusay
- Walang mga kahinaan sa seguridad

## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/example/service/DynamicMetricService.java` sa sumusunod na format:

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

## Expected Output

Sa isang result na nakalat sa `src/main/java/com/example/service/DynamicMetricService.java` na format na ibinigay ng:

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

## File Structure

- **Root folder**: `src/main/java/com/example/service/`
- **Source folder**: `src/main/java/`
- **Test folder**: `test/java/`
- **Package structure**:
    - **Package: com.example.service **
        - **Service: DynamicMetricService **
            - **Interface: DynamicMetricService **
                - **Method: calculate **
                    - **Parameters: String formula, Map<String, Object> context **
                        - **Parameter: String formula **
                            - **Type: String **
                        - **Parameter: Map<String, Object> context **
                            - **Type: Map **
    - **Test classes: test/java/com/example/service/DynamicMetricServiceTest.java **

## References

- [Java 8+](http://www.oracle.com/technetwork/articles/javase/javase8-compatibility-guide-2156366.html)
- [JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
- [JavaScript Engine](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ScriptEngine)
- [JavaScript Engine Manager](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ScriptEngineManager)

"""

from util import get_file_str
from docx import Document
from docx.enum.text import WD_BREAK
from docx.shared import Pt

filename = 'DynamicMetricService.xml'
output = get_file_str(filename