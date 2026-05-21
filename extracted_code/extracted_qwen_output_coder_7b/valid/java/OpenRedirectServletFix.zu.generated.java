import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RedirectService {

    private static final Set<String> ALLOWED_URLS = new HashSet<>();

    static {
        ALLOWED_URLS.add("/dashboard");
        ALLOWED_URLS.add("/profile");
        // Add other allowed URLs here
    }

    public void performRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String returnUrl = request.getParameter("returnUrl");

        if (returnUrl == null ||