#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Calculate the required buffer size
    size_t required_size = strlen("ip addr ") + strlen(ip_addr) + strlen(" netmask ") + strlen(netmask) + strlen(" gateway ") + strlen(gateway) + 1;

    // Check if the buffer is large enough
    if (required_size > buffer_size) {
        return -1;
    }

    /* Simulan ang pagbuo ng command */
    strcpy(cmd_buffer, "ip addr ");

    /* Isama ang IP address */
    strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer) - 1);

    /* Isama ang netmask part */
    strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer) - 1);

    /* Isama ang gateway part */
    strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer) - 1);

    return 0;
}