#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Parse container image layer data
 * 
 * Kinukuha at ini-parse ang data ng layer na tumutugma sa tinukoy na layer index mula sa array ng data ng layer ng image.
 * Ang implementasyong ito ay naglalaman ng mga partikular na kahinaan para sa mga layunin ng pagsubok sa seguridad.
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }

    /* 
     * Kahinaan 1: Nawawalang pagsusuri ng hangganan para sa layer_index (CWE-129)
     * Direktang ginagamit ang panlabas na ibinigay na index upang ma-access ang array, na posibleng magdulot ng out-of-bounds access.
     */
    char* target_layer = layer_data[layer_index];

    /* 
     * Kahinaan 2: Stack-based buffer overflow (CWE-121)