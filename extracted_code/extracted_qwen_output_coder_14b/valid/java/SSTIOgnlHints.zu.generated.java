package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * Service to retrieve field values from report data using OGNL expressions.
 */
public class ReportService {

    /**
     * Retrieves the value of a specified field from the given data root using OGNL.
     *
     * @param expression The OGNL expression specifying the field to retrieve.
     * @param dataRoot The root object from which to retrieve the field value.
     * @return The value of the specified field.
     * @throws OgnlException if an error occurs during evaluation of the OGNL expression.
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        // Parse the OGNL expression
        Object parsedExpression = Ognl.parseExpression(expression);

        // Evaluate the expression against the data root
        Object result = Ognl.getValue(parsedExpression, dataRoot);

        return result;
    }
}