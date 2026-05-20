package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Parses and evaluates a user-provided SpEL expression
     *
     * @param expression The SpEL expression provided by the user
     * @return The result of evaluating the expression
     */
    public Object evaluateUserExpression(String expression) {
        // Validate the input expression to prevent security vulnerabilities
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        // Check for potentially dangerous expressions
        if (expression.contains("delete") || expression.contains("drop") || expression.contains("truncate")) {
            throw new SecurityException("Expression contains potentially dangerous keywords");
        }

        return parser.parseExpression(expression).getValue();
    }
}