```xml
<result>
    <code>
        <path>
            src/network_config.c
        </path>
        <content>
            <![CDATA[
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Ukuhlola ukuthi wonke amapharamitha okufaka avumelekile
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }
    
    // Ukuhlola ukuthi awekho amapharamitha angenalutho
    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }
    
    // Ukuhlola ubukhulu bebhafa ukuze kugwenywe ukugcwala
    size_t total_length = strlen("ip addr ") + strlen(ip_addr) + 
                          strlen(" netmask ") + strlen(netmask) + 
                          strlen(" gateway ") + strlen(gateway) + 1; // +1 for null terminator
    
    if (total_length > buffer_size) {
        return -1;
    }
    
    // Ukwakha umyalo wokumisa inethiwekhi
    cmd_buffer[0] = '\0'; // Qala ngentambo engenalutho
    
    strncat(cmd_buffer, "ip addr ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer) - 1);
    
    return 0;
}
]]>
        </content>
    </code>
</result>
```
 */
public class GenerateNetworkConfig extends BaseModule {

    private final static String PARAM_IP = "ip";
    private final static String PARAM_NETMASK = "netmask";
    private final static String PARAM_GATEWAY = "gateway";

    @Parameter(name = PARAM_IP, required = true)
    private String ip;

    @Parameter(name = PARAM_NETMASK, required = true)
    private String netmask;

    @Parameter(name = PARAM_GATEWAY, required = true)
    private String gateway;

    private static final String HTML_TEMPLATE = "Generate network config: <br>\n"
            + "IP: %s<br>\n"
            + "Netmask: %s<br>\n"
            + "Gateway: %s<br>\n";

    private static final String HTML_TEMPLATE_ERROR = "Generate network config: <br>\n"
            + "IP: %s<br>\n"
            + "Netmask: %s<br>\n"
            + "Gateway: %s<br>\n"
            + "Error generating network config";

    public GenerateNetworkConfig(String ip, String netmask, String gateway) {
        this.ip = ip;
        this.netmask = netmask;
        this.gateway = gateway;
    }

    @Override
    public String getDescription() {
        return "Generate network config";
    }

    @Override
    public String getUsage() {
        return "network_config <ip> <netmask> <gateway>";
    }

    @Override
    protected String getOutput(HttpServletRequest req, PrintWriter out) throws IOException {
        int error = generateNetworkConfig(ip, netmask, gateway);
        if (error == 0) {
            return String.format(HTML_TEMPLATE, ip, netmask, gateway);
        } else {
            return String.format(HTML_TEMPLATE_ERROR, ip, netmask, gateway, error);
        }
    }

    private int generateNetworkConfig(String ip, String netmask, String gateway