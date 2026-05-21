package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    /**
     * Retrieves field value from the data source based on an OGNL expression.
     * @param expression OGNL expression string
     * @param dataRoot data source object
     * @return result of the expression evaluation
     * @throws OgnlException thrown when OGNl expression parsing or execution fails
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        try {
            return Ognl.getValue(expression, dataRoot);
        } catch (OgnlException e) {
            throw new OgnlException("Error evaluating OGNL expression: " + expression, e);
        }
    }
}