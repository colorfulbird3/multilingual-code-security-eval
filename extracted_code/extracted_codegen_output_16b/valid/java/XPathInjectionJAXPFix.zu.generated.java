public class WebService extends Service {

    public WebService(String baseUrl) {
        super(baseUrl, "POST");
    }

    @Override
    protected String getUrl() {
        return this.baseUrl + "/web-service/";
    }

    @Override
    protected void execute(String body) {

    }

    @Override
    protected void validate() {

    }

    public String findUsernameByEmail(String email) {
        return "";
    }

    public String findPasswordByEmail(String email) {
        return "";
    }

}