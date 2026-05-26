```xml
<result>
    <code>
        <path>
            src/network_config.c
        </path>
        <content>
            <![CDATA[
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
]]>
        </content>
    </code>
</result>
```
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

// Ukuthi ngenala ena nw_addr
struct nw_addr {
    char* ip_addr;
    char* netmask;
    char* gateway;
};

// Ukuthi ngenala ena cmd_buffer
char cmd_buffer[1024];

// Ukuthi ngenala ena net_config
struct net_config {
    char* ip_addr;
    char* netmask;
    char* gateway;
};

int generate_network_config_cmd(char* cmd_buffer, size_t buffer_size, const char* ip_addr, const char* netmask, const char* gateway) {
    // Ukuthi ngenala ena cmd_buffer
    snprintf(cmd_buffer, buffer_size, "ip addr %s netmask %s gateway %s", ip_addr, netmask, gateway);
    
    return 0;
}

int main() {
    struct nw_addr addr = {
        "192.168.1.2",
        "255.255.255.0",
        "192.168.1.1"
    };
    
    struct net_config net_config = {
        "192.168.1.2",
        "255.255.255.0",
        "192.168.1.1"
    };
    
    generate_network_config_cmd(cmd_buffer, 1024, addr.ip_addr, addr.netmask, addr.gateway);
    
    printf("%s", cmd_buffer);
    
    return 0;
}
```
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet