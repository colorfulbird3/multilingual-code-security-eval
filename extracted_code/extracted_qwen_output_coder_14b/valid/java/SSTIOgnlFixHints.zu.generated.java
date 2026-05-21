package com.example.report;

import ognl.Ognl;
import ognl.OgnlException;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    public Object getReportFieldValue(String expression, Object root) throws OgnlException {
        return Ognl.getValue(expression, root);
    }
}