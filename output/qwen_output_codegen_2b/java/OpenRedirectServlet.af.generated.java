Request request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException`
// - Kernlogika: Gebruik die `javax.servlet.http.HttpServletResponse#sendRedirect`-metode om die herleiding uit te voer.
// - Toepaslike uitsonderingshantering word vereis.
// - Kode moet bondig en doeltreffend wees.
// ## Uitsetformaat
// Voer die volledige kode vir `src/main/java/com/example/service/RedirectService.java` in die volgende formaat uit:
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
// ## Voorbeelden
// - `src/main/java/com/example/service/RedirectService.java`
// - `src/main/resources/conf/konfiguratie.xml`

@Path("redirect")
public class RedirectService {

  @GET
  @Path("/performRedirect")
  public void performRedirect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.sendRedirect(req.getParameter("returnUrl"));
  }
}
