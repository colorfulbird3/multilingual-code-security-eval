package com.example.service;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    public Object evaluateUserExpression(String expression) {
        // Initialize the parser
        ExpressionParser parser = new SpelExpressionParser();

        // Parse and evaluate the expression
        Expression exp = parser.parseExpression(expression);
        Object result = exp.getValue();

        return result;
    }
}