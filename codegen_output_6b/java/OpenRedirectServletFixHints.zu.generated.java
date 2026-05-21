enalutho noma engenalutho kufanele iqondise kabusha ekhasini lasekhaya.
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }

        // Qondisa kabusha umsebenzisi kwi-URL yokubuya ecacisiwe.
        response.sendRedirect(returnUrl);
    }
}
]]>
        </content>
    </code>
</result>
```
 */
public class RedirectService {

    private static final String[] BANNER_PACKAGE_NAMES = {"com.example.service", "com.example.service.impl"};

    private static final String[] BANNER_CLASS_NAMES = {"RedirectService", "RedirectServiceImpl"};

    private static final String[] BANNER_METHOD_NAMES = {"performRedirect", "performRedirect"};

    private static final String[] BANNER_MESSAGE_CONTENT = {"Ifunda i-URL yokubuya esicelweni bese iqondisa kabusha ukuhambisa kabusha.",
        "Qondisa kabusha umsebenzisi kwi-URL yokubuya ecacisiwe."};

    public static void main(String[] args) {
        Banner banner = new Banner(BANNER_PACKAGE_NAMES, BANNER_CLASS_NAMES, BANNER_METHOD_NAMES, BANNER_MESSAGE_CONTENT);
        banner.print(System.out);
    }

    public static class Banner {
        private final String[] packageNames;
        private final String[] classNames;
        private final String[] methodNames;
        private final String[] messageContents;

        private Banner(String[] packageNames, String[] classNames, String[] methodNames, String[] messageContents) {
            this.packageNames = packageNames;
            this.classNames = classNames;
            this.methodNames = methodNames;
            this.messageContents = messageContents;
        }

        public void print(PrintStream out) {
            out.println("<!-- BANNER -->");
            out.println("<result>");
            for (int i = 0; i < packageNames.length; i++) {
                out.println("<code>");
                out.println("<path>" + packageNames[i] + "</path>");
                out.println("<content>");
                for (int j = 0; j < classNames.length; j++) {
                    out.println("<![CDATA[");
                    out.print("package " + packageNames[i]);
