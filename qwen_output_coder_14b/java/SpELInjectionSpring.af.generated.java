Hier is die volledige kode vir `src/main/java/com/example/service/ExpressionService.java`:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ExpressionService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    public Object evaluateUserExpression(String expression) {
        ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(expression).getValue();
    }
}
            ]]>
        </content>
    </code>
</result>
```