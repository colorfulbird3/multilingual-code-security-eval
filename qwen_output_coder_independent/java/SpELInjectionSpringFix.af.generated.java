```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ExpressionService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Ontleed en evalueer 'n SpEL-uitdrukking wat deur die gebruiker verskaf is.
     *
     * @param expression Die SpEL-uitdrukking wat deur die gebruiker verskaf is
     * @return Die resultaat van die evaluering van die uitdrukking
     */
    public Object evaluateUserExpression(String expression) {
        return parser.parseExpression(expression).getValue();
    }
}
            ]]>
        </content>
    </code>
</result>
```