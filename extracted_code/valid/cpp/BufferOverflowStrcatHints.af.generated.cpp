#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check if any input string parameter is empty
    if (ip_addr == NULL || netmask == NULL || gateway == NULL ||
        ip_addr[0] == '\0' || netmask[0] == '\0' || gateway[0] == '\0') {
        return -1;
    }

    // Construct the network configuration command string
    int result = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    
    // Check if the snprintf call was successful
    if (result < 0) {
        return -1;
    }

    // Ensure the command string fits within the buffer
    if ((size_t)result >= buffer_size) {
        return -1;
    }

    return 0;
}