package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    /**
     * Evaluates the given OGNL expression on the provided data root object.
     *
     * @param expression The OGNL expression string to evaluate.
     * @param dataRoot   The root object for the OGNL expression evaluation.
     * @return The evaluated result of the OGNL expression.
     * @throws OgnlException If there is an error evaluating the expression.
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}