package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Parses and evaluates the SpEL expression provided by the user.
     *
     * @param expression The SpEL expression provided by the user
     * @return The result of evaluating the expression
     */
    public Object evaluateUserExpression(String expression) {
        return parser.parseExpression(expression).getValue();
    }
}