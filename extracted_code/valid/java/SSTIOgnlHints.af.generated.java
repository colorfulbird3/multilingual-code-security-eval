package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    /**
     * Evaluates the given OGNL expression on the provided data root object.
     *
     * @param expression The OGNL expression to evaluate.
     * @param dataRoot   The root object for the OGNL expression evaluation.
     * @return The result of evaluating the OGNL expression.
     * @throws OgnlException If an error occurs during the evaluation.
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}