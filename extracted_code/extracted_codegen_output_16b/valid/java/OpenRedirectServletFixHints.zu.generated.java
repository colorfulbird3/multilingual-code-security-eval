@Controller
public class RedirectServiceController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/redirect")
    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Thola i-URL yendawo oya kuyo kusukela kupharamitha yesicelo.
        String returnUrl = request.getParameter("returnUrl");

        // I-returnUrl engenalutho noma engenalutho kufanele iqondise kabusha ekhasini lasekhaya.
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }

        // Qondisa kabusha umsebenzisi kwi-URL yokubuya ecacisiwe.
        response.sendRedirect(returnUrl);
    }

    @RequestMapping("/redirect-message")
    public void performRedirectMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Thola i-URL yendawo oya kuyo kusukela kupharamitha yesicelo.
        String returnUrl = request.getParameter("returnUrl");

        // I-returnUrl engenalutho noma engenalutho kufanele iqondise kabusha ekhasini lasekhaya.
        if (returnUrl == null || returnUrl.trim().isEmpty()) {
            response.sendRedirect("/");
            return;
        }

        // Qondisa kabusha umsebenzisi kwi-URL yokubuya ecacisiwe.
        response.sendRedirect(messageSource.getMessage("redirect.message", null, null));
    }

    @ExceptionHandler
    public void handleException(Exception exception, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}