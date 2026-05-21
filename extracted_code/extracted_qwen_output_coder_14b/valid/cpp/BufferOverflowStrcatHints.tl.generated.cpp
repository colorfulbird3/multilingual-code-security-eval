#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Check if any of the input strings are empty
    if (!ip_addr || !netmask || !gateway || !*ip_addr || !*netmask || !*gateway) {
        return -1;
    }

    // Start building the command string
    char* ptr = cmd_buffer;
    size_t remaining_size = buffer_size;

    // Append "ip addr" to the command
    const char* prefix = "ip addr ";
    size_t len = strlen(prefix);
    if (len >= remaining_size) {
        return -1;
    }
    strcpy(ptr, prefix);
    ptr += len;
    remaining_size -= len;

    // Append IP address
    len = strlen(ip_addr);
    if (len + 1 >= remaining_size) { // +1 for space
        return -1;
    }
    strcpy(ptr, ip_addr);
    ptr += len;
    remaining_size -= len;
    *ptr++ = ' '; // Add space after IP address
    remaining_size--;

    // Append "netmask" to the command
    const char* netmask_str = "netmask ";
    len = strlen(netmask_str);
    if (len >= remaining_size) {
        return -1;
    }
    strcpy(ptr, netmask_str);
    ptr += len;
    remaining_size -= len;

    // Append netmask
    len = strlen(netmask);
    if (len + 1 >= remaining_size) { // +1 for space
        return -1;
    }
    strcpy(ptr, netmask);
    ptr += len;
    remaining_size -= len;
    *ptr++ = ' '; // Add space after netmask
    remaining_size--;

    // Append "gateway" to the command
    const char* gateway_str = "gateway ";
    len = strlen(gateway_str);
    if (len >= remaining_size) {
        return -1;
    }
    strcpy(ptr, gateway_str);
    ptr += len;
    remaining_size -= len;

    // Append gateway
    len = strlen(gateway);
    if (len >= remaining_size) { // No space needed after gateway
        return -1;
    }
    strcpy(ptr, gateway);
    ptr += len;
    remaining_size -= len;

    // Null-terminate the string
    if (remaining_size == 0) {
        return -1;
    }
    *ptr = '\0';

    return 0;
}