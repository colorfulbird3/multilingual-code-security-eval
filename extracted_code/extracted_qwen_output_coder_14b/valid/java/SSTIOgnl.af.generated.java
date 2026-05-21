package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    /**
     * Evaluates an OGNL expression against a given root object.
     *
     * @param expression The OGNL expression to evaluate.
     * @param dataRoot   The root object against which the expression should be evaluated.
     * @return The result of evaluating the OGNL expression.
     * @throws OgnlException If there is an error during evaluation.
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        // Parse the OGNL expression
        Object parsedExpression = Ognl.parseExpression(expression);
        
        // Evaluate the expression against the data root
        Object result = Ognl.getValue(parsedExpression, dataRoot);
        
        return result;
    }
}