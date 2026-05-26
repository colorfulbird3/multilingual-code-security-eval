```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ReportService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

public class ReportService {

    /**
     * Kinukuha ang halaga ng field mula sa data source batay sa isang OGNL expression.
     * @param expression Ang string ng OGNL expression
     * @param dataRoot Ang object ng data source
     * @return Ang resulta ng pagsusuri ng expression
     * @throws OgnlException Itinataas kapag nabigo ang pag-parse o pag-execute ng OGNL expression
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        OgnlContext context = new OgnlContext();
        context.setMemberAccess(new DefaultMemberAccess(true));
        return Ognl.getValue(Ognl.parseExpression(expression), context, dataRoot);
    }
}
            ]]>
        </content>
    </code>
</result>
```