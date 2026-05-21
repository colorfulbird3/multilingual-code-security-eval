Here is the Java code for the `ExpressionService` class that implements the `evaluateUserExpression` method using Spring Expression Language (SpEL):

```java
package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    public Object evaluateUserExpression(String expression) {
        // Create an instance of SpelExpressionParser
        ExpressionParser parser = new SpelExpressionParser();

        // Parse and evaluate the expression
        Object result = parser.parseExpression(expression).getValue();

        return result;
    }
}
```

This code defines a Spring service called `ExpressionService` with a method `evaluateUserExpression` that takes a SpEL expression as a string, parses it, evaluates it, and returns the result. The method uses the `SpelExpressionParser` class from the Spring framework to handle the parsing and evaluation of the expression.