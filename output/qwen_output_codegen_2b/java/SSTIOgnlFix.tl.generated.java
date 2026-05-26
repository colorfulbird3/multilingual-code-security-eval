// ["Java8+", "ognl:ognl:3.3.4"]
// ## Output Format
// I-output ang kumpletong naayos na code para sa `src/main/java/com/example/service/ReportService.java` sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Sample Results
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Source Code
// ## Java Code
// ```java
// package com.example.service;
// import ognl.Ognl;
// import ognl.OgnlException;
// import ognl.OgnlRuntime;
// public class ReportService {
// /**
// * Retrieves field value from the data source based on an OGNL expression.
// * @param expression OGNL expression string
// * @param dataRoot data source object
// * @return result of the expression evaluation
// * @throws OgnlException thrown when OGNL expression parsing or execution fails
// */
// public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
// return Ognl.getValue(expression, dataRoot);
// }
// }
// ```
// ## OGNL Java code
// - src/main/java/com/example/service/ReportService.java
// ```java
// package com.example.service;
// import ognl.Ognl;
// import ognl.OgnlRuntime;
// import ognl.OgnlException;
// import ognl.OgnlRuntime.OgnlBindException;
// public class ReportService {
// /**
// * Retrieves field value from the data source based on an OGNL expression.
// * @param expression OGNL expression string
// * @param dataRoot data source object
// * @return result of the expression evaluation
// * @throws OgnlException thrown when OGNL expression parsing or execution fails
// */
// public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
// try {
// return Ognl.getValue(expression, dataRoot);
// } catch (OgnlBindException e) {
// return OgnlRuntime.resolve(e.getBind(), e.getContext());
// }
// }
// }
// ```
// ## OGNL XML Code
// - src/main/xml/com/example/model/User.xml
// ```xml
// <report>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </report>
// ```
// ## Sample Results
// ```xml
// <report>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </report>
// ```
// ## Source Code
// ## Java Code
// ```java
// package com.example.service;
// import ognl.Ognl;
// import ognl.OgnlRuntime;
// import ognl.OgnlException;
// import ognl.OgnlRuntime.OgnlBindException;
// public class ReportService {
// /**
// * Retrieves field value from the data source based on an OGNL expression.
// * @param expression OGNL expression string
// * @param dataRoot data source object
// * @return result of the expression evaluation
// * @throws OgnlException thrown when OGNL expression parsing or execution fails
// */
// public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
// try {
// return Ognl.getValue(expression, dataRoot);
// } catch (OgnlBindException e) {
// return OgnlRuntime.resolve(e.getBind(), e.getContext());
// }
// }
// }
// ```
// ## OGNL XML Code
// - src/main/xml/com/example/model/User.xml
// ```xml
// <report>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
//