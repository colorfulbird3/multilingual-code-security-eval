#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check if any of the input strings are empty
    if (!ip_addr || !netmask || !gateway || strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Start constructing the command string
    char* pos = cmd_buffer;

    // Copy the base command part
    const char* base_command = "ip addr ";
    size_t len = strlen(base_command);
    if (len >= buffer_size) {
        return -1;
    }
    strcpy(pos, base_command);
    pos += len;

    // Append the IP address
    len = strlen(ip_addr);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, ip_addr);
    pos += len;

    // Append the netmask
    const char* netmask_str = " netmask ";
    len = strlen(netmask_str);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, netmask_str);
    pos += len;

    len = strlen(netmask);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, netmask);
    pos += len;

    // Append the gateway
    const char* gateway_str = " gateway ";
    len = strlen(gateway_str);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, gateway_str);
    pos += len;

    len = strlen(gateway);
    if (buffer_size - (pos - cmd_buffer) <= len) {
        return -1;
    }
    strcat(pos, gateway);
    pos += len;

    // Null-terminate the string
    *pos = '\0';

    return 0;
}