package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

/**
 * Service para sa pagkuha ng field value mula sa isang data object gamit ang OGNL expression.
 */
public class ReportService {

    /**
     * Kinukuha at sinusuri ang field value mula sa ibinigay na data object batay sa OGNL expression.
     *
     * @param expression Ang OGNL expression string na tutukoy sa field na kukunin.
     * @param dataRoot Ang root object na pagmumulan ng data.
     * @return Ang resulta ng pagsusuri ng expression.
     * @throws OgnlException Kung may error sa pag-parse o pagsusuri ng expression.
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}