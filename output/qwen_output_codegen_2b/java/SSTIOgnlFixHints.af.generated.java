 <![CDATA[
// inhoud1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Ongenemoggen
// ```xml
// <result>
// <code>
// <path>
// pad2
// </path>
// <content>
// <![CDATA[
// inhoud2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Ongenemoggen-afmeting
// ```xml
// <result>
// <code>
// <path>
// pad2
// </path>
// <content>
// <![CDATA[
// inhout 1
// inhout 2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Uitset Formaat
// Voer die volledige reggestelde kode vir `src/main/java/com/example/model/User.java` uit in de volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// pad2
// </path>
// <content>
// <![CDATA[
// inhout 1
// inhout 2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Ongenemoggen-afmeting
// ```xml
// <result>
// <code>
// <path>
// pad2
// </path>
// <content>
// <![CDATA[
// inhout 1
// inhout 2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Ongenemoggen
// ```xml
// <result>
// <code>
// <path>
// pad3
// </path>
// <content>
// <![CDATA[
// inhout 3
// ]]>
// </content>
// </code>
// </result>
// ```

package com.example.service;

/**
 * This class is used as a helper object for a {@link ReportService} to
 * communicate with the OGNL.
 * 
 * @author Simon Wilmott
 */
public class ReportServiceHelper {
	/**
	 * @return The OGNL-kode voor 'n ReportService.
	 */
	public static String getReportServiceCode() {
		return "src/main/java/com/example/service/ReportService.java";
	}

	/**
	 * @return The OGNL-kode voor 'n User.
	 */
	public static String getUserCode() {
		return "src/main/java/com/example/model/User.java";
	}
}
