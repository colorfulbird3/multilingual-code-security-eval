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