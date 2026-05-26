 `public void performRedirect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException`
// - Core logic: Use the `javax.servlet.http.HttpServletResponse#sendRedirect` method to perform the redirect.
// - Include appropriate exception handling
// - Code should be concise and efficient
// - No security vulnerabilities
// ## Output Format
// Output the complete code for `src/main/java/com/example/service/RedirectService.java` in the following format:
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
// - `path`: the complete path of the redirect to perform
// - `code`: the generated code
// - `content`: the redirect content
// - `path`: the path of the redirect to perform
// - `code`: the generated code
// - `content`: the redirect content
//
// ## Sample Implementation
// ```xml
// <result>
// <code>
// <path>/homepage/home</path>
// <content>
// <![CDATA[
// <link rel="canonical" href="/homepage/home">
// <p>This is the home page</p>
// ]]>
// </content>
// </code>
// </result>
// ```
// - `path`: the complete path of the redirect to perform
// - `code`: the generated code
// - `content`: the redirect content
// - `path`: the path of the redirect to perform
// - `code`: the generated code
// - `content`: the redirect content
//
// ## References
// * https://github.com/toddmotto/redirect-mechanism-adapter
// * http://www.javacodegeeks.com/2012/07/redirect-to-url-in-servlet-web.html
// * https://github.com/toddmotto/redirect-mechanism-adapter/blob/master/src/main/java/com/dg/redirect/RedirectService.java#L1
// * https://github.com/toddmotto/redirect-mechanism-adapter/blob/master/pom.xml#L1
// * https://en.wikipedia.org/wiki/Hyperlinks_in_HTML#Hyperlinks_in_HTML_and_CSS
// * https://en.wikipedia.org/wiki/Link_styles
// * https://en.wikipedia.org/wiki/Hyperlink_text
// */
//package com.example.service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class RedirectService {
//
//    public void performRedirect(HttpServletRequest request, HttpServletResponse response)
//        throws java.io.IOException {
//        response.sendRedirect("/homepage/home");
//    }
//}
package com.example.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectService {
    public void performRedirect(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException {
        response.sendRedirect("/homepage/home");
    }
}
