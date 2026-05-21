 volgende formaat:

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

*/

/**
 * @author Janneke Brouwer - jbrouwer@huygens.knaw.nl
 */
package com.example;

import java.util.Map;

public class ExpressionService {

    private final ExpressionParser parser;

    /**
     * Parses and evaluates a user-provided SpEL expression
     *
     * @param expression The SpEL expression provided by the user
     * @return The result of evaluating the expression
     */
    public Object evaluateUserExpression(String expression) {
        return parser.parseExpression(expression).getValue();
    }

    public ExpressionService() {
        this.parser = new SpelExpressionParser();
    }

    void validate() {
        if (expressionIsNullOrEmpty()) {
            throw new IllegalArgumentException("expression is null or empty");
        }
    }

    boolean expressionIsNullOrEmpty() {
        return expression == null || expression.isEmpty();
    }

    public static class SpelExpressionParser implements ExpressionParser {

        @Override
        public Object parseExpression(String expression) {
            return null;
        }

        @Override
        public Object parseExpression(String expression, Map<String, Object> context) {
            return null;
        }
    }
}
