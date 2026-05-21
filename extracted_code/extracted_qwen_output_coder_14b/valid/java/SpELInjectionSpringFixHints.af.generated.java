package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Parses and evaluates a user-provided SpEL expression
     *
     * @param expression The SpEL expression provided by the user
     * @return The result of evaluating the expression
     */
    public Object evaluateUserExpression(String expression) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        return parser.parseExpression(expression, new TemplateParserContext()).getValue(context);
    }
}