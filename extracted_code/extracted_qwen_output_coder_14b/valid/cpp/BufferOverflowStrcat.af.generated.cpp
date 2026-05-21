#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check for empty input parameters
    if (!ip_addr || !netmask || !gateway || !*ip_addr || !*netmask || !*gateway) {
        return -1;
    }

    // Start constructing the command string
    size_t len = snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    
    // Check if the constructed string fits within the buffer
    if (len >= buffer_size) {
        return -1;
    }

    return 0;
}