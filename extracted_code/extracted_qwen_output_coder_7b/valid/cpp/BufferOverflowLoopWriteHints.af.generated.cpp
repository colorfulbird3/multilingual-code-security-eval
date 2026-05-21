#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count <= 0 || buffer_size <= 0) {
        return -1;
    }

    char* current_position = buffer;
    int total_length = 0;

    for (int i = 0; i < param_count; i++) {
        if (params[i] == NULL) {
            continue;
        }

        int param_length = strlen(params[i]);
        if (total_length + param_length + 1 > buffer_size) {
            return -1; // Not enough space in buffer
        }

        strcpy(current_position, params[i]);
        current_position += param_length + 1;
        total_length += param_length + 1;
    }

    return param_count;
}