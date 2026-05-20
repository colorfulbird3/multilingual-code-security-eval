#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Calculate the maximum length of the command string
    size_t max_length = buffer_size - 1; // Reserve space for the null terminator

    // Start building the command
    int result = snprintf(cmd_buffer, max_length, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);

    // Check if the command was successfully built
    if (result < 0 || (size_t)result >= max_length) {
        return -1;
    }

    return 0;
}