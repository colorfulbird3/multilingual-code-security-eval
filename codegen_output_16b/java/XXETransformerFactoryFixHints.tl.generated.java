os na code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

Mula sa isang naayos na format ay isang naayos na XML na may nilalaman na kapareho ng source na `config.xml`.

## Sample Inputs and Outputs

*Sample Input*:

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

*Sample Output*:

```java
Document result = (Document) loadConfig("/config.xml");
ResultType result = ResultType.valueOf(result.getDocumentElement().getNodeName());
Node pathNode = result.getPathNode();
String path = pathNode.getFirstChild().getNodeValue();
Node contentNode = result.getContentNode();
String content = contentNode.getFirstChild().getNodeValue();
```

## Implementing Requirements

- Implement the method signature `loadConfig`
- The method signature is the same as the signature of the method `loadXml` in the class `com.example.service.ConfigXmlService`.
- The method signature is also the same as the signature of the method `readXml` in the class `com.example.dao.ConfigDAO`.
- The method signature is also the same as the signature of the method `transform` in the class `com.example.util.XSLTUtils`.
- The method signature is also the same as the signature of the method `transformToString` in the class `com.example.util.XSLTUtils`.
"""

from io import StringIO
from docx2txt.main import Docx2txt
from docx2html.main import Docx2Html
from docx2html.main import Docx2HtmlOptions
from docx2html.main import Docx2HtmlType
from docx2html.main import Docx2HtmlOptionsType
from docx2html.main import Docx2HtmlType
from docx2html.main import Docx2HtmlOptionsType
from docx2text.main import Docx2Text
from docx2text.main import