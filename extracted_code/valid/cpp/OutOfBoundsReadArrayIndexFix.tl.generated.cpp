#include "data_compressor.h"

/**
 * Decompress data
 * 
 * Decompresses data using the RLE algorithm.
 * This implementation contains an out-of-bounds read vulnerability (CWE-125).
 */
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    if (compressed_data == NULL || output_buffer == NULL || compressed_len <= 0 || output_size <= 0) {
        return -1;
    }

    int input_index = 0;
    int output_index = 0;

    /* 
     * Fixed vulnerability trigger point: The loop condition now checks whether input_index + 2 is less than compressed_len.
     * This ensures that we do not attempt to read beyond the end of the compressed data buffer.
     */
    while (input_index + 2 <= compressed_len) {
        unsigned char count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        for (int i = 0; i < (int)count; i++) {
            if (output_index < output_size) {
                output_buffer[output_index++] = value;
            } else {
                /* If the output buffer is full but the input stream