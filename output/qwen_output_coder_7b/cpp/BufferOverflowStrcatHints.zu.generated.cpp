Here is the implementation of the `generate_network_config_cmd` function in C:

```c
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) > 15 || strlen(netmask) > 15 || strlen(gateway) > 15) {
        return -1;
    }

    if (buffer_size < 128) {
        return -1;
    }

    int result = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    if (result < 0 || result >= buffer_size) {
        return -1;
    }

    return 0;
}
```

This function takes in the command buffer, buffer size, and the IP address, netmask, and gateway as parameters. It checks for null pointers and invalid string lengths before generating the network configuration command using `snprintf`. If the command generation is successful, it returns 0; otherwise, it returns -1.