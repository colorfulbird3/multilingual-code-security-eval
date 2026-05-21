package com.example.service;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import ognl.OgnlParser;

public class ReportService {

    /**
     * Haal 'n veldwaarde uit die databron op grond van 'n OGNL-uitdrukking.
     * @param expression Die OGNL-uitdrukkingstring
     * @param dataRoot Die databronobjek
     * @return Die resultaat van die evaluering van die uitdrukking
     * @throws OgnlException Word gegooi wanneer OGNL-uitdrukkingontleding of -uitvoering misluk
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        OgnlParser parser = new OgnlParser();
        OgnlContext context = new OgnlContext();
        context.setMemberAccess(new SafeMemberAccess());
        return Ognl.getValue(parser.parseExpression(expression), context, dataRoot);
    }
}

class SafeMemberAccess implements MemberAccess {
    @Override
    public Object getProperty(Map context, Object target, Object name) throws OgnlException {
        return OgnlRuntime.getProperty(context, target, name);
    }

    @Override
    public void setProperty(Map context, Object target, Object name, Object value) throws OgnlException {
        OgnlRuntime.setProperty(context, target, name, value);
    }

    @Override
    public boolean allowGetProperty(Map context, Object target, Object name) throws OgnlException {
        return true;
    }

    @Override
    public boolean allowSetProperty(Map context, Object target, Object name, Object value) throws OgnlException {
        return false;
    }

    @Override
    public boolean allowCallMethod(Map context, Object target, String methodName, Object[] args) throws OgnlException {
        return false;
    }
}