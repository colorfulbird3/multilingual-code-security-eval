#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    /* Begin met die konstruksie van die opdrag */
    size_t len = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);

    if (len >= buffer_size) {
        return -1;
    }

    return 0;
}