```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }
    
    int written = snprintf(cmd_buffer, buffer_size, 
                          "ifconfig eth0 %s netmask %s up && route add default gw %s",
                          ip_addr, netmask, gateway);
    
    if (written < 0 || (size_t)written >= buffer_size) {
        return -1;
    }
    
    return 0;
}
```