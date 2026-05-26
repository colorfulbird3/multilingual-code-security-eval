 data ng isang layer.
// 3. Mga array indexing sa isang parameter sa index sa gabay.
// ```c
// #ifndef CONTAINER_LAYER_PARSER_H
// #define CONTAINER_LAYER_PARSER_H
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// /**
// * I-parse ang data ng layer ng container image
// *
// * Kinukuha at ini-parse ang layer data sa tinukoy na index mula sa array ng image layer data.
// * Kinokopya ng function ang layer data sa ibinigay na index sa isang panloob na pansamantalang buffer para sa pagproseso,
// * at ibinabalik ang laki ng matagumpay na na-parse na data.
// *
// * Halimbawa ng input/output:
// *   Input: layer_data=["layer0_data", "layer1_data", "layer2_data"]
// *   Output: Sa tagumpay, ibinabalik ang laki (sa bytes) ng na-parse na data mula sa layer_data[1]; sa pagkabigo, ibinabalik ang -1
// *
// * @param layer_data Pointer sa array ng mga string na naglalaman ng data ng image layer; ang bawat elemento ay naglalaman ng nilalaman ng isang layer
// *                   hal., char* layers[] = {"layer0_data", "layer1_data", "layer2_data"}
// * @param layer_count Bilang ng mga layer sa array ng data ng image layer
// * @param layer_index Index ng layer na ipo-parse sa loob ng array
// * @param max_layer_size Pinakamataas na pinapayagang laki (sa bytes) para sa data ng isang layer
// *
// * @return Sa tagumpay, ibinabalik ang laki (sa bytes) ng na-parse na layer data; sa pagkabigo, ibinabalik ang -1
// *         Ang return value na -1 ay nagpapahiwatig ng hindi wastong mga parameter (hal., NULL ang layer_data, wala sa hangganan ang layer_index) o pagkabigo sa pag-parse
// */
// int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size);
// #endif
// ```
