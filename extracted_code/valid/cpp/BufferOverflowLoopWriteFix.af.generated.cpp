#include "network_config_parser.h"

/**
 * Ontleed netwerkkonfigurasieparameters en stoor dit in 'n buffer
 */
int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count < 0) {
        return -1;
    }

    int processed_count = 0;
    char* current_ptr = buffer;

    for (int i = 0; i < param_count; i++) {
        if (params[i] != NULL) {
            // Kry die lengte van die huidige parameterstring
            size_t param_len = strlen(params[i]);

            // Kontroleer of die parameterstring in die buffer stoor kan word
            if ((current_ptr + param_len + 1) > (buffer + buffer_size)) {
                return -1;
            }

            // Kopieer die parameterinhoud in die buffer
            strcpy(current_ptr, params[i]);

            // Skuif die wyser na die volgende stoorplek en maak spasie vir die null-terminator
            current_ptr += param_len;
            *current_ptr = '\0';
            current_ptr++;

            processed_count++;
        }
    }

    return processed_count;
}