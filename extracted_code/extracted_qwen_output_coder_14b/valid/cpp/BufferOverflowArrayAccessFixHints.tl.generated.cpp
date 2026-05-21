#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Parse container image layer data
 * 
 * Kinukuha at ini-parse ang data ng layer na tumutugma sa tinukoy na layer index mula sa array ng data ng layer ng image.
 * Kinokopya ng function ang data ng layer sa tinukoy na index sa isang panloob na pansamantalang buffer para sa pagproseso at ibinabalik ang laki ng matagumpay na na-parse na data.
 *
 * Halimbawa ng input/output:
 *   Input: layer_data=["layer0","layer1","layer2"], layer_count=3, layer_index=1, max_layer_size=64
 *   Output: Sa tagumpay, ibinabalik ang laki (sa bytes) ng na-parse na data mula sa layer_data[1]; sa pagkabigo, ibinabalik ang -1
 *
 * @param layer_data Pointer sa isang array ng mga string na naglalaman ng data ng layer ng image, kung saan ang bawat elemento ay naglalaman ng nilalaman ng isang layer ng image
 *                   hal., char* layers[] = {"layer0_data", "layer1_data", "layer2_data"}
 * @param layer_count Bilang ng mga layer sa array ng data ng layer ng image
 * @param layer_index Posisyon ng index ng layer ng image na ipo-parse sa loob ng array
 * @param max_layer_size Pinakamataas na pinapayagang laki (sa bytes) para sa data ng isang solong layer ng image
 * 
 * @return Sa tagumpay, ibinabalik ang laki (sa bytes) ng na-parse na data ng layer; sa pagkabigo, ibinabalik ang -1
 *         Ang return value na -1 ay nagpapahiwatig ng hindi wastong mga parameter (hal., NULL ang layer_data, wala sa saklaw ang layer_index) o pagkabigo sa pag-parse
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    // Pagsusuri ng mga parameter
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }

    // Pagkuha ng target layer
    char* target_layer = layer_data[layer_index];

    // Pagkuha ng haba ng target layer
    size_t target_length = strlen(target_layer);

    // Pagsusuri ng max_layer_size
    if (target_length > max_layer_size) {
        return -1;
    }

    // Kinokopya ang data ng layer sa isang panloob na buffer
    char* temp_buffer = (char*)malloc(max_layer_size + 1);
    if (temp_buffer == NULL) {
        return -1;
    }

    strncpy(temp_buffer, target_layer, max_layer_size);
    temp_buffer[max_layer_size] = '\0';

    int processed_size = (int)target_length;

    // I-release ang temporary buffer
    free(temp_buffer);

    return processed_size;
}