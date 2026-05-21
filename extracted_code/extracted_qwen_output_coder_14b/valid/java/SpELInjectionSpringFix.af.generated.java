package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Ontleed en evalueer 'n SpEL-uitdrukking wat deur die gebruiker verskaf is.
     *
     * @param expression Die SpEL-uitdrukking wat deur die gebruiker verskaf is
     * @return Die resultaat van die evaluering van die uitdrukking
     */
    public Object evaluateUserExpression(String expression) {
        try {
            return parser.parseExpression(expression).getValue();
        } catch (Exception e) {
            // Hier kan u 'n aangepaste foute afhandeling invoeg, bv. om 'n foute boodskap terug te stuur
            throw new RuntimeException("Fout tydens die evaluering van die uitdrukking: " + e.getMessage(), e);
        }
    }
}