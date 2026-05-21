#include <stdio.h>
#include <string.h>

int main() {
    char buffer[100];
    char* params[] = {"ip=192.168.1.1", "port=8080", "protocol=tcp"};
    int param_count = sizeof(params) / sizeof(params[0]);

    int result = parse_network_config_params(buffer, sizeof(buffer), params, param_count);

    if (result >= 0) {
        printf("Parsed %d parameters successfully.\n", result);
        printf("Buffer content: %s\n", buffer);
    } else {
        printf("Failed to parse parameters.\n");
    }

    return 0;
}