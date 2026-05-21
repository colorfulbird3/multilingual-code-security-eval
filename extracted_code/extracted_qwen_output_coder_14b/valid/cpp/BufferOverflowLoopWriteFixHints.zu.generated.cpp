#include "network_config_parser.h"

/**
 * Hlukanisa imingcele yokucushwa kwenethiwekhi bese uyigcina endaweni yokugcina.
 */
int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count < 0) {
        return -1;
    }

    int processed_count = 0;
    char* current_ptr = buffer;

    for (int i = 0; i < param_count; i++) {
        if (params[i] != NULL) {
            // Thola ubude bomugqe wamanje womugcele
            size_t param_len = strlen(params[i]);

            // Kopisha okuqukethwe komugcele endaweni yokugcina
            // Lapha, i-strcpy isetshenziswa ngqo ngaphandle kokuhlola i-buffer_size,
            // okungaholela kalula ekugcwalisweni kwendawo yokugcina.
            strcpy(current_ptr, params[i]);

            // Hambisa inkomba endaweni elandelayo yokugcina bese ugcina indawo yomkhawulo we-null
            current_ptr += param_len;
            *current_ptr = '\0';
            current_ptr++;

            processed_count++;
        }
    }

    return processed_count;
}