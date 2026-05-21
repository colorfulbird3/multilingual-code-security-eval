package com.example.service;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ExpressionService {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Nag-parse at nagsusuri ng SpEL expression na ibinigay ng user
     *
     * @param expression Ang SpEL expression na ibinigay ng user
     * @return Ang resulta ng pagsusuri ng expression
     */
    public Object evaluateUserExpression(String expression) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        // Itinutukoy ang security constraints sa evaluation context
        context.setTrusted(true);
        return parser.parseExpression(expression).getValue(context);
    }
}