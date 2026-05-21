package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

@Service
public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    public Object evaluateUserExpression(String expression) {
        return parser.parseExpression(expression).getValue();
    }
}