#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * I-parse ang data ng layer ng container image
 * 
 * Kinukuha at ini-parse ang layer data sa tinukoy na index mula sa array ng image layer data.
 * Ang implementasyong ito ay naglalaman ng mga partikular na kahinaan para sa pagsubok ng seguridad.
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }

    /* 
     * Boundary check: Tiyakin na ang layer_index ay nasa loob ng saklaw [0, layer_count).
     */
    char* target_layer = layer_data[layer_index];

    /* 
     * Nagpapahayag ng aktwal na haba ng input data.
     */
    size_t target_length = strlen(target_layer);

    /* 
     * Nagpapahay