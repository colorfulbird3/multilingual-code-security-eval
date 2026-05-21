#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    int total_length = 0;

    for (int i = 0; i < param_count; i++) {
        int param_length = strlen(params[i]);
        
        // Check if adding this parameter will exceed the buffer size
        if (total_length + param_length + 1 > buffer_size) {
            return -1; // Not enough space in the buffer
        }

        // Copy the parameter into the buffer
        strcpy(buffer + total_length, params[i]);
        total_length += param_length + 1; // Add 1 for the null terminator
    }

    return param_count; // Return the number of successfully parsed parameters
}