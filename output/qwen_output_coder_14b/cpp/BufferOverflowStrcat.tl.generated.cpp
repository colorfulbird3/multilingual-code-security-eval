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
    // Check if any input string parameter is empty
    if (!ip_addr || !netmask || !gateway || !*ip_addr || !*netmask || !*gateway) {
        return -1;
    }

    // Initialize the command buffer
    cmd_buffer[0] = '\0';

    // Construct the command string
    if (strncat(cmd_buffer, "ip addr ", buffer_size - strlen(cmd_buffer)) == cmd_buffer) {
        return -1;
    }
    if (strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer)) == cmd_buffer) {
        return -1;
    }
    if (strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer)) == cmd_buffer) {
        return -1;
    }
    if (strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer)) == cmd_buffer) {
        return -1;
    }
    if (strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer)) == cmd_buffer) {
        return -1;
    }
    if (strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer)) == cmd_buffer) {
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```