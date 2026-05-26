</result>
```
 */
public class XPathService implements Service {

    @Override
    public boolean isInitialized() {
        return true;
    }

    @Override
    public void init(Context context) throws ServiceException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public String getName() {
        return "xpath";
    }

    @Override
    public String getDescription() {
        return "XPath service";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public void invoke(String method, String params, String sessionId, Message message) throws ServiceException {
        if (method.equals("findUserRoleByUsername")) {
            findUserRoleByUsername(params, message);
        }
    }

    private void findUserRoleByUsername(String params, Message message) throws ServiceException {
        int pIndex = params.indexOf("&");
        if (pIndex < 0) {
            throw new ServiceException("Invalid method arguments");
        }
        String param = params.substring(0, pIndex);
        String username = param.substring(param.indexOf("=") + 1, param.length());
        String role = findUserRoleByUsername(username);
        message.setResult(role);
    }
}
