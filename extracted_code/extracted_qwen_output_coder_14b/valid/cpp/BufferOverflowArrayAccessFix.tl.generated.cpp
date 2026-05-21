#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * I-parse ang data ng layer ng container image
 * 
 * Kinukuha at ini-parse ang layer data sa tinukoy na index mula sa array ng image layer data.
 * Kinokopya ng function ang layer data sa ibinigay na index sa isang panloob na pansamantalang buffer para sa pagproseso,
 * at ibinabalik ang laki ng matagumpay na na-parse na data.
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    /* 
     * I-validate ang layer_index kung ito ay nasa loob ng legal na range
     */
    char* target_layer = layer_data[layer_index];

    /* 
     * Gumamit ng dynamic memory allocation para sa ligtas na pagkopya ng data
     */
    char* temp_buffer = (char*)malloc((max_layer_size + 1) * sizeof(char));
    if (temp_buffer == NULL) {
        return -1;
    }

    /* 
     * Gumamit ng strncpy upang kopyahin ang source data sa isang dynamically allocated buffer
     */
    strncpy(temp_buffer, target_layer, max_layer_size);
    temp_buffer[max_layer_size] = '\0'; // Ensure null-termination

    int processed_size = (int)strlen(temp_buffer);

    free(temp_buffer);

    return processed_size;
}