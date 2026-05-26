![CDATA[
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    /* Begin met die konstruksie van die opdrag */
    strcpy(cmd_buffer, "ip addr ");

    /* Voeg IP-adres saam */
    strcat(cmd_buffer, ip_addr);

    /* Voeg subnetmasker deel saam */
    strncat(cmd_buffer, " netmask ", 9);
    strcat(cmd_buffer, netmask);

    /* Voeg hek deel saam */
    strcat(cmd_buffer, " gateway ");
    strncat(cmd_buffer, gateway, strlen(gateway));

    return 0;
}
]]>
        </content>
    </code>
</result>
```
