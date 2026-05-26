```xml
<result>
    <code>
        <path>src/main/java/com/example/service/ReportService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    /**
     * Retrieves field value from the data source based on an OGNL expression.
     * @param expression OGNL expression string
     * @param dataRoot data source object
     * @return result of the expression evaluation
     * @throws OgnlException thrown when OGNL expression parsing or execution fails
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}
            ]]>
        </content>
    </code>
</result>
```