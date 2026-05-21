Here's the requested code for `src/network_config.c`:

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
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    /* Start constructing the command */
    strcpy(cmd_buffer, "ip addr ");

    /* Concatenate IP address */
    strcat(cmd_buffer, ip_addr);

    /* Concatenate netmask part */
    strncat(cmd_buffer, " netmask ", 9);
    strcat(cmd_buffer, netmask);

    /* Concatenate gateway part */
    strcat(cmd_buffer, " gateway ");
    strncat(cmd_buffer, gateway, strlen(gateway));

    return 0;
}
]]>
        </content>
    </code>
</result>
```

This code defines the `generate_network_config_cmd` function which constructs a network configuration command string based on the provided IP address, subnet mask, and gateway parameters. It uses `strcpy`, `strcat`, and `strncat` functions to concatenate the strings into the command buffer. The function checks if any of the input pointers are `NULL` or if any of the input strings are empty, returning `-1` in such cases to indicate failure. If successful, it returns `0`.