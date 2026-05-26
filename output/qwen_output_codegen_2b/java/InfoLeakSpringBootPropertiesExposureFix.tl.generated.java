 maikli at episyente ang configuration file
// ## Output Format
// I-output ang kumpletong fixed code para sa `src/main/resources/application.properties` sa sumusunod na format:
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
// ## Test Tool
// I-Test Tool for verification, `src/test/resources/test-service/system-info-service.xml`
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

@Path("/system-info-service")
@Produces("application/json")
public class SystemInfoService extends AbstractService {

    @Context
    private UriInfo uriInfo;

    public SystemInfoService(String... springBootApplicationName) {
        super(springBootApplicationName);
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public JsonNode getConfiguration() {
        JsonNode configuration = null;
        try {
            configuration = objectMapper.readTree(new URL(springBootApplicationName[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuration;
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    public JsonNode saveConfiguration(JsonNode configuration) {
        JsonNode result = null;
        try {
            result = objectMapper.readTree(new URL(springBootApplicationName[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public JsonNode getCode() {
        JsonNode result = null;
        try {
            result = objectMapper.readTree(new URL(springBootApplicationName[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public JsonNode getSource() {
        JsonNode result = null;
        try {
            result = objectMapper.readTree(new URL(springBootApplicationName[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
