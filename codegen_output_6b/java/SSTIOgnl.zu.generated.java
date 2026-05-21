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

/**
 * Service for handling OGNL-based report field extraction.
 */
public class ReportService {

    /**
     * Evaluates an OGNL expression against a given data root object and returns the result.
     *
     * @param expression the OGNL expression string to evaluate
     * @param dataRoot   the root object for the OGNL expression evaluation
     * @return the evaluated result from the OGNL expression
     * @throws ognl.OgnlException if the expression parsing or evaluation fails
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        // Use OGNL library to parse and evaluate the expression against the data root
        return Ognl.getValue(expression, dataRoot);
    }
}
            ]]>
        </content>
    </code>
</result>
```

*
 * @author  Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version $Id$
 */
public class EvaluateExpressionOnDataObject {

	// empty on purpose
}
