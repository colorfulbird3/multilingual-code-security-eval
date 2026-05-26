path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Code Sample
// ```java
// ReportService reportService = new ReportService();
// Object dataRoot = new HashMap();
// Object ognlResult = reportService.getReportFieldValue("user.name", dataRoot);
// String path = (String) ognlResult;
// System.out.println(path);
// // do something with path
// ```
// ## References
// https://github.com/apache/commons-lang/blob/master/lang/src/main/java/org/apache/commons/lang/OGNLUtils.java

package com.app.pagpapatupatupa.pagpapatupadynamicreport;

import java.util.HashMap;
import java.util.Map;

public class DynamicReport {

    public Map<String, Object> getReportFieldValue(String expression, Object dataRoot) throws Exception {
        // load class file and instantiate
        Class<?> classfile = DynamicReport.class.getClassLoader().loadClass("com.app.pagpapatupatupa.pagpapatupadynamicreport.ReportService");
        // prepare to call getReportFieldValue
        Object ognlResult = null;
        try {
            ognlResult = classfile.getDeclaredMethod("getReportFieldValue", String.class, Object.class)
                   .invoke(classfile, expression, dataRoot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return the ognl result
        return (Map<String, Object>) ognlResult;
    }
}
