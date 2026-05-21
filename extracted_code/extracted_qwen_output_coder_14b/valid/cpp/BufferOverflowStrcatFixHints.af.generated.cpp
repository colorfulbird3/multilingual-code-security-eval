#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }

    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }

    // Bereken die totale lengte van die netwerkopdragstring
    size_t total_length = strlen("ip addr ") + strlen(ip_addr) + strlen(" netmask ") + strlen(netmask) + strlen(" gateway ") + strlen(gateway) + 1;

    // Kontroleer of die buffer groot genoeg is
    if (total_length > buffer_size) {
        return -1;
    }

    /* Begin met die bou van die opdrag */
    strcpy(cmd_buffer, "ip addr ");

    // Voeg IP-adres by
    strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer) - 1);

    // Voeg netmasker-gedeelte by
    strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer) - 1);

    // Voeg hek-gedeelte by
    strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer) - 1);

    return 0;
}