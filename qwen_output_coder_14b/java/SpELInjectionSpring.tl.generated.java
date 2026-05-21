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
import org.springframework.expression.Expression;

public class ExpressionService {

    public Object evaluateUserExpression(String expression) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expression);
        return exp.getValue();
    }
}
            ]]>
        </content>
    </code>
</result>
```