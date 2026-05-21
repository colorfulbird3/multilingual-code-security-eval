#include "network_config_parser.h"

/**
 * I-parse ang network configuration parameters at i-store ang mga ito sa isang buffer
 */
int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count < 0) {
        return -1;
    }

    int processed_count = 0;
    char* current_ptr = buffer;

    for (int i = 0; i < param_count; i++) {
        if (params[i] != NULL) {
            // Kunin ang haba ng kasalukuyang parameter string
            size_t param_len = strlen(params[i]);

            // Tiyak na ang buffer ay kapasitang magpunta sa lahat ng data na kailangan ito i-store
            if (current_ptr + param_len + 1 > buffer + buffer_size) {
                return -1; // Buffer overflow detected
            }

            // Kopyahin ang parameter content sa buffer
            strcpy(current_ptr, params[i]);

            // Ilipat ang pointer sa susunod na storage location at mag-reserve ng space para sa null terminator
            current_ptr += param_len + 1;

            processed_count++;
        }
    }

    return processed_count;
}