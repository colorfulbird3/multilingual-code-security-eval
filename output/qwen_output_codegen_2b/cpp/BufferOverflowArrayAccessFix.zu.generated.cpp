// ```xml
// <result>
// <code>
// <path>
// src/container_layer_parser.c
// </path>
// <content>
// <![CDATA[
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// #include <stdint.h>
// /**
// * Parse container image layer data
// *
// * Extracts and parses the layer data at the specified index from the image layer data array.
// * This implementation contains specific vulnerabilities for security testing.
// */
// int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
// if (layer_data == NULL) {
// return -1;
// }
// /*
// * Vulnerability 1: Missing boundary check for layer_index (CWE-129)
// * Directly uses externally provided index to access array, potentially causing out-of-bounds access.
// */
// char* target_layer = layer_data[layer_index];
// /*
// * Vulnerability 2: Stack-based buffer overflow (CWE-121)
// * Defines a fixed-size stack buffer but does not validate the actual length of input data.
// */
// char temp_buffer[256];
// /*
// * Vulnerability 3: Unsafe string copy (CWE-120)
// * Uses strcpy to copy source data into a fixed-size buffer.
// * If the data pointed to by target_layer exceeds 255 bytes, a buffer overflow occurs.
// */
// strcpy(temp_buffer, target_layer);
// int processed_size = (int)strlen(temp_buffer);
// /*
// * Even though max_layer_size is checked here, the overflow has already occurred.
// */
// if (processed_size > max_layer_size) {
// return -1;
// }
// return processed_size;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
