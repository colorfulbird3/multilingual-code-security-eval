```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ExpressionService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    public Object evaluateUserExpression(String expression) {
        return parser.parseExpression(expression).getValue(new StandardEvaluationContext());
    }
}
            ]]>
        </content>
    </code>
</result>
```