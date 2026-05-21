package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}