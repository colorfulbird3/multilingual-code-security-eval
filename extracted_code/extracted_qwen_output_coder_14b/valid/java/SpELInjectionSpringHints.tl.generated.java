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