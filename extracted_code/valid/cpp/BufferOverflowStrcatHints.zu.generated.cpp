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