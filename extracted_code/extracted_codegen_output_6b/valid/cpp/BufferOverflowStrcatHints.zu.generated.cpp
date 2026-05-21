```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <errno.h>

#define MAX_INTERFACES 10
#define MAX_IP_LENGTH 46
#define MAX_MAC_LENGTH 18
#define MAX_INTERFACE_NAME_LENGTH 16

typedef struct {
    char name[MAX_INTERFACE_NAME_LENGTH];
    char ip_address[MAX_IP_LENGTH];
    char subnet_mask[MAX_IP_LENGTH];
    char gateway[MAX_IP_LENGTH];
    char mac_address[MAX_MAC_LENGTH];
    int is_up;
    int mtu;
} NetworkInterface;

typedef struct {
    NetworkInterface interfaces[MAX_INTERFACES];
    int interface_count;
    char hostname[256];
    char dns_servers[3][MAX_IP_LENGTH];
    int dns_count;
} NetworkConfig;

int initialize_network_config(NetworkConfig *config) {
    if (config == NULL) {
        return -1;
    }
    
    memset(config, 0, sizeof(NetworkConfig));
    config->interface_count = 0;
    config->dns_count = 0;
    
    if (gethostname(config->hostname, sizeof(config->hostname)) != 0) {
        strcpy(config->hostname, "unknown");
    }
    
    return 0;
}

int add_interface(NetworkConfig *config, const char *name, const char *ip, 
                  const char *subnet, const char *gateway, const char *mac, 
                  int is_up, int mtu) {
    if (config == NULL || name == NULL || config->interface_count >= MAX_INTERFACES) {
        return -1;
    }
    
    NetworkInterface *iface = &config->interfaces[config->interface_count];
    
    strncpy(iface->name, name, MAX_INTERFACE_NAME_LENGTH - 1);
    iface->name[MAX_INTERFACE_NAME_LENGTH - 1] = '\0';
    
    if (ip != NULL) {
        strncpy(iface->ip_address, ip, MAX_IP_LENGTH - 1);
        iface->ip_address[MAX_IP_LENGTH - 1] = '\0';
    }
    
    if (subnet != NULL) {
        strncpy(iface->subnet_mask, subnet, MAX_IP_LENGTH - 1);
        iface->subnet_mask[MAX_IP_LENGTH - 1] = '\0';
    }
    
    if (gateway != NULL) {
        strncpy(iface->gateway, gateway, MAX_IP_LENGTH - 1);
        iface->gateway[MAX_IP_LENGTH - 1] = '\0';
    }
    
    if (mac != NULL) {
        strncpy(iface->mac_address, mac, MAX_MAC_LENGTH - 1);
        iface->mac_address[MAX_MAC_LENGTH - 1] = '\0';
    }
    
    iface->is_up = is_up;
    iface->mtu = mtu;
    
    config->interface_count++;
    return 0;
}

int add_dns_server(NetworkConfig *config, const char *dns_server) {
    if (config == NULL || dns_server == NULL || config->dns_count >= 3) {
        return -1;
    }
    
    strncpy(config->dns_servers[config->dns_count], dns_server, MAX_IP_LENGTH - 1);
    config->dns_servers[config->dns_count][MAX_IP_LENGTH - 1] = '\0';
    config->dns_count++;
    
    return 0;
}

int validate_ip_address(const char *ip_address) {
    if (ip_address == NULL) {
        return -1;
    }
    
    struct sockaddr_in sa;
    return inet_pton(AF_INET, ip_address, &(sa.sin_addr));
}

int validate_mac_address(const char *mac_address) {
    if (mac_address == NULL) {
        return -1;
    }
    
    int octets[6];
    if (sscanf(mac_address, "%x:%x:%x:%x:%x:%x", 
               &octets[0], &octets[1], &octets[2], 
               &octets[3], &octets[4], &octets[5]) != 6) {
        return -1;
    }
    
    for (int i = 0; i < 6; i++) {
        if (octets[i] < 0 || octets[i] > 255) {
            return -1;
        }
    }
    
    return 0;
}

void print_interface_info(const NetworkInterface *iface) {
    if (iface == NULL) {
        return;
    }
    
    printf("Interface: %s\n", iface->name);
    printf("  IP Address: %s\n", iface->ip_address);
    printf("  Subnet Mask: %s\n", iface->subnet_mask);
    printf("  Gateway: %s\n", iface->gateway);
    printf("  MAC Address: %s\n", iface->mac_address);
    printf("  Status: %s\n", iface->is_up ? "UP" : "DOWN");
    printf("  MTU: %d\n", iface->mtu);
}

void print_network_config(const NetworkConfig *config) {
    if (config == NULL) {
        return;
    }
    
    printf("Network Configuration\n");
    printf("=====================\n");
    printf("Hostname: %s\n\n", config->hostname);
    
    printf("Interfaces (%d):\n", config->interface_count);
    for (int i = 0; i < config->interface_count; i++) {
        print_interface_info(&config->interfaces[i]);
        printf("\n");
    }
    
    printf("DNS Servers (%d):\n", config->dns_count);
    for (int i = 0; i < config->dns_count; i++) {
        printf("  %d. %s\n", i + 1, config->dns_servers[i]);
    }
}

int save_config_to_file(const NetworkConfig *config, const char *filename) {
    if (config == NULL || filename == NULL) {
        return -1;
    }
    
    FILE *file = fopen(filename, "w");
    if (file == NULL) {
        return -1;
    }
    
    fprintf(file, "# Network Configuration File\n");
    fprintf(file, "HOSTNAME=%s\n", config->hostname);
    fprintf(file, "INTERFACE_COUNT=%d\n", config->interface_count);
    
    for (int i = 0; i < config->interface_count; i++) {
        fprintf(file, "\n[INTERFACE_%d]\n", i);
        fprintf(file, "NAME=%s\n", config->interfaces[i].name);
        fprintf(file, "IP_ADDRESS=%s\n", config->interfaces[i].ip_address);
        fprintf(file, "SUBNET_MASK=%s\n", config->interfaces[i].subnet_mask);
        fprintf(file, "GATEWAY=%s\n", config->interfaces[i].gateway);
        fprintf(file, "MAC_ADDRESS=%s\n", config->interfaces[i].mac_address);
        fprintf(file, "IS_UP=%d\n", config->interfaces[i].is_up);
        fprintf(file, "MTU=%d\n", config->interfaces[i].mtu);
    }
    
    fprintf(file, "\nDNS_COUNT=%d\n", config->dns_count);
    for (int i = 0; i < config->dns_count; i++) {
        fprintf(file, "DNS_SERVER_%d=%s\n", i + 1, config->dns_servers[i]);
    }
    
    fclose(file);
    return 0;
}

int load_config_from_file(NetworkConfig *config, const char *filename) {
    if (config == NULL || filename == NULL) {
        return -1;
    }
    
    FILE *file = fopen(filename, "r");
    if (file == NULL) {
        return -1;
    }
    
    initialize_network_config(config);
    
    char line[256];
    int current_interface = -1;
    
    while (fgets(line, sizeof(line), file)) {
        line[strcspn(line, "\n")] = 0;
        
        if (line[0] == '#' || line[0] == '\0') {
            continue;
        }
        
        if (strncmp(line, "HOSTNAME=", 9) == 0) {
            strncpy(config->hostname, line + 9, sizeof(config->hostname) - 1);
        }
        else if (strncmp(line, "INTERFACE_COUNT=", 16) == 0) {
            config->interface_count = atoi(line + 16);
        }
        else if (strncmp(line, "[INTERFACE_", 11) == 0) {
            current_interface = atoi(line + 11);
        }
        else if (current_interface >= 0 && current_interface < MAX_INTERFACES) {
            NetworkInterface *iface = &config->interfaces[current_interface];
            
            if (strncmp(line, "NAME=", 5) == 0) {
                strncpy(iface->name, line + 5, MAX_INTERFACE_NAME_LENGTH - 1);
            }
            else if (strncmp(line, "IP_ADDRESS=", 11) == 0) {
                strncpy(iface->ip_address, line + 11, MAX_IP_LENGTH - 1);
            }
            else if (strncmp(line, "SUBNET_MASK=", 12) == 0) {
                strncpy(iface->subnet_mask, line + 12, MAX_IP_LENGTH - 1);
            }
            else if (strncmp(line, "GATEWAY=", 8) == 0) {
                strncpy(iface->gateway, line + 8, MAX_IP_LENGTH - 1);
            }
            else if (strncmp(line, "MAC_ADDRESS=", 12) == 0) {
                strncpy(iface->mac_address, line + 12, MAX_MAC_LENGTH - 1);
            }
            else if (strncmp(line, "IS_UP=", 6) == 0) {
                iface->is_up = atoi(line + 6);
            }
            else if (strncmp(line, "MTU=", 4) == 0) {
                iface->mtu = atoi(line + 4);
            }
        }
        else if (strncmp(line, "DNS_COUNT=", 10) == 0) {
            config->dns_count = atoi(line + 10);
        }
        else if (strncmp(line, "DNS_SERVER_", 11) == 0) {
            char *equals = strchr(line, '=');
            if (equals != NULL) {
                int index = atoi(line + 11) - 1;
                if (index >= 0 && index < 3) {
                    strncpy(config->dns_servers[index], equals + 1, MAX_IP_LENGTH - 1);
                }
            }
        }
    }
    
    fclose(file);
    return 0;
}

void cleanup_network_config(NetworkConfig *config) {
    if (config == NULL) {
        return;
    }
    
    memset(config, 0, sizeof(NetworkConfig));
}

int main() {
    NetworkConfig config;
    
    if (initialize_network_config(&config) != 0) {
        fprintf(stderr, "Failed to initialize network configuration\n");
        return 1;
    }
    
    add_interface(&config, "eth0", "192.168.1.100", "255.255.255.0", 
                  "192.168.1.1", "00:11:22:33:44:55", 1, 1500);
    add_interface(&config, "wlan0", "10.0.0.5", "255.255.255.0", 
                  "10.0.0.1", "AA:BB:CC:DD:EE:FF", 1, 1500);
    
    add_dns_server(&config, "8.8.8.8");
    add_dns_server(&config, "8.8.4.4");
    
    print_network_config(&config);
    
    if (save_config_to_file(&config, "network.conf") != 0) {
        fprintf(stderr, "Failed to save configuration\n");
    }
    
    NetworkConfig loaded_config;
    if (load_config_from_file(&loaded_config, "network.conf") == 0) {
        printf("\nLoaded configuration:\n");
        print_network_config(&loaded_config);
        cleanup_network_config(&loaded_config);
    }
    
    cleanup_network_config(&config);
    
    return 0;
}
```