#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    int total_length = 0;
    int current_position = 0;

    // Iterate over each parameter
    for (int i = 0; i < param_count; i++) {
        int param_length = strlen(params[i]) + 1; // +1 for the null terminator

        // Check if there is enough space in the buffer
        if (current_position + param_length > buffer_size) {
            return -1; // Not enough space in the buffer
        }

        // Copy the parameter into the buffer
        strcpy(buffer + current_position, params[i]);
        current_position += param_length;
        total_length++;
    }

    return total_length; // Return the number of successfully parsed parameters
}