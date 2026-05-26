

## Uitsetsmaken

Wat gebeurt is dat:

    - Voor alle geën kode-uitdrukkingen en
    - Voor de evaluator met SpEL in de nieuwe formaat (maar niet langer)

## Bijvoorbeeld

Optimaliseer die volgende Java-kode:

```java
package com.example.service;

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
```

## Bijvoorbeeld

Optimaliseer de volgende Java-kode:

```java
package com.example.service;

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
```

## Bijvoorbeeld

Gebruik de volgende.groovy-kode:

```groovy
import