```xml
<result>
    <code>
        <path>src/network_config.c</path>
        <content>
            <![CDATA[
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (ip_addr == NULL || netmask == NULL || gateway == NULL || strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    const char* command_template = "ip addr %s netmask %s gateway %s";
    int result = snprintf(cmd_buffer, buffer_size, command_template, ip_addr, netmask, gateway);
    if (result < 0 || result >= buffer_size) {
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```