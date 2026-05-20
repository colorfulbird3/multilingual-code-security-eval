package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;
import org.apache.commons.lang3.StringUtils;

public class ReportService {

    /**
     * Haal 'n veldwaarde uit die databron op grond van 'n OGNL-uitdrukking.
     * @param expression Die OGNL-uitdrukkingstring
     * @param dataRoot Die databronobjek
     * @return Die resultaat van die evaluering van die uitdrukking
     * @throws OgnlException Word gegooi wanneer OGNL-uitdrukkingontleding of -uitvoering misluk
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        if (StringUtils.isBlank(expression)) {
            throw new IllegalArgumentException("OGNL expression cannot be blank");
        }
        return Ognl.getValue(expression, dataRoot);
    }
}