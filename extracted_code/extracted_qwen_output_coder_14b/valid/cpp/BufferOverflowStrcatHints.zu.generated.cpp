#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check if any of the input parameters are NULL or empty
    if (!cmd_buffer || !ip_addr || !netmask || !gateway || buffer_size == 0) {
        return -1;
    }

    // Create the command string
    snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);

    // Ensure the command string fits within the buffer
    if (strlen(cmd_buffer) >= buffer_size) {
        return -1;
    }

    return 0;
}