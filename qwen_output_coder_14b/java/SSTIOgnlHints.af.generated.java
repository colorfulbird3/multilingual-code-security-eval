Hier is die implementering van die `ReportService`-klas met die `getReportFieldValue`-metode:

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
import ognl.OgnlException;

public class ReportService {

    /**
     * Evaluates an OGNL expression against a given root data object.
     *
     * @param expression the OGNL expression to evaluate
     * @param dataRoot the root object against which to evaluate the expression
     * @return the result of evaluating the expression
     * @throws OgnlException if there is an error during evaluation
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        try {
            // Parse and evaluate the OGNL expression
            Object result = Ognl.getValue(expression, dataRoot);
            return result;
        } catch (OgnlException e) {
            // Handle any exceptions that occur during evaluation
            throw new OgnlException("Error evaluating OGNL expression: " + expression, e);
        }
    }
}
]]>
        </content>
    </code>
</result>
```

Hierdie implementering gebruik die `Ognl.getValue`-metode om die OGNL-uitdrukking te evalueer teen die gegewe data-objek. As er 'n fout optreed tydens die evaluering, word 'n `OgnlException` gesigneerd.