```c
#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    /* Begin met die bou van die opdrag */
    if (strlen("ip addr ") >= buffer_size) {
        return -1;
    }
    strcpy(cmd_buffer, "ip addr ");

    /* Voeg IP-adres by */
    size_t remaining_space = buffer_size - strlen(cmd_buffer);
    if (strlen(ip_addr) >= remaining_space) {
        return -1;
    }
    strcat(cmd_buffer, ip_addr);

    /* Voeg netmasker-gedeelte by */
    remaining_space