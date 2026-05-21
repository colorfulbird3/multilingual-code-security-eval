#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    int total_length = 0;
    for (int i = 0; i < param_count; i++) {
        int param_length = strlen(params[i]);
        if (total_length + param_length + 1 > buffer_size) {
            // If adding the next parameter exceeds buffer size, return error
            return -1;
        }
        strcpy(buffer + total_length, params[i]);
        total_length += param_length + 1;
    }
    return param_count;
}