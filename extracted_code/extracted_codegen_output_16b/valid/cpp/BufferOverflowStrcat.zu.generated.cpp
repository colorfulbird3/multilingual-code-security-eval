#include "network_config.h"

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Ukuhlola ukuthi wonke amapharamitha okufaka avumelekile
    if (cmd_buffer == NULL || ip_addr == NULL || netmask == NULL || gateway == NULL) {
        return -1;
    }
    
    // Ukuhlola ukuthi awekho amapharamitha angenalutho
    if (strlen(ip_addr) == 0 || strlen(netmask) == 0 || strlen(gateway) == 0) {
        return -1;
    }
    
    // Ukuhlola ubukhulu bebhafa ukuze kugwenywe ukugcwala
    size_t total_length = strlen("ip addr ") + strlen(ip_addr) + 
                          strlen(" netmask ") + strlen(netmask) + 
                          strlen(" gateway ") + strlen(gateway) + 1; // +1 for null terminator
    
    if (total_length > buffer_size) {
        return -1;
    }
    
    // Ukwakha umyalo wokumisa inethiwekhi
    cmd_buffer[0] = '\0'; // Qala ngentambo engenalutho
    
    strncat(cmd_buffer, "ip addr ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, ip_addr, buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, " netmask ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, netmask, buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, " gateway ", buffer_size - strlen(cmd_buffer) - 1);
    strncat(cmd_buffer, gateway, buffer_size - strlen(cmd_buffer) - 1);
    
    return 0;
}