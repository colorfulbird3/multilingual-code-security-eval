#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    /* Simulan ang pagbuo ng command */
    size_t current_length = snprintf(cmd_buffer, buffer_size, "ip addr %s", ip_addr);
    if (current_length >= buffer_size) {
        return -1;
    }

    /* Isama ang netmask na bahagi */
    current_length += snprintf(cmd_buffer + current_length, buffer_size - current_length, " netmask %s", netmask);
    if (current_length >= buffer_size) {
        return -1;
    }

    /* Isama ang gateway na bahagi */
    current_length += snprintf(cmd_buffer + current_length, buffer_size - current_length, " gateway %s", gateway);
    if (current_length >= buffer_size) {
        return -1;
    }

    return 0;
}