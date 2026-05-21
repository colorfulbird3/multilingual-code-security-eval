#include "network_config_parser.h"

/**
 * Parse network configuration parameters and store them into a buffer.
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

            // Sumailalim kung kung may sufficient space para sa parameter at null terminator
            if (current_ptr + param_len + 1 > buffer + buffer_size) {
                return -1; // Hindi maaari na i-store ang parameter dahil sa insufficient space
            }

            // Kopyahin ang nilalaman ng parameter sa buffer
            strcpy(current_ptr, params[i]);

            // Ilipat ang pointer sa susunod na storage location at mag-reserve ng space para sa null terminator
            current_ptr += param_len;
            *current_ptr = '\0';
            current_ptr++;

            processed_count++;
        }
    }

    return processed_count;
}