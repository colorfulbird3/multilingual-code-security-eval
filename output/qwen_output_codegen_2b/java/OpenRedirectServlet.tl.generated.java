in ang `javax.servlet.http.HttpServletResponse#sendRedirect` na pamamaraan upang isagawa ang pag-redirect.
// - Kinakailangan ang naaangkop na paghawak ng eksepsyon.
// - Ang code ay dapat maikli at mahusay.
// ## Format ng Output
// I-output ang kumpletong code para sa `src/main/java/com/example/service/RedirectService.java` sa sumusunod na format:
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
// ## Mga Kinakailangan sa Pahina
// - File path: `src/main/java/com/example/service/RedirectService.java`
// - Package name: `com.example.service`
// - Class name: `RedirectService`
// - Method signature: `public void performRedirect(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException`
// - Core logic: Gamitin ang `javax.servlet.http.HttpServletResponse#sendRedirect` na pamamaraan upang isagawa ang pag-redirect.
// - Kinakailangan ang naaangkop na pahina.
// - Ang code ay dapat maikli at mahusay.
// - Kapatin ang kahulingan sa isang pag-log in at pag-log-in sa isang target na pahina.
// ## I-redirect
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
// ## X-redirect
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
// ## Error-redirect
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
// ## Error-redirect
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
// ## I-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## Error-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## I-error-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## Error-error-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## I-error-error-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## Error-error-error-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## I-error-error-error-error-redirect
// <result>
// <code>
// <path>
// path1
// </path>
// <error>
// <![CDATA[
// error1
// ]]>
// </error>
// </code>
// </result>
// ## Error-error-error-error-error-redirect
// <