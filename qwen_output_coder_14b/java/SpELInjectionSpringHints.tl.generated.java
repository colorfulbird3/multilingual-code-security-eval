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
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionService {

    public Object evaluateUserExpression(String expression) {
        // Create an instance of the parser
        ExpressionParser parser = new SpelExpressionParser();

        // Parse and evaluate the expression
        return parser.parseExpression(expression).getValue();
    }
}
            ]]>
        </content>
    </code>
</result>
```