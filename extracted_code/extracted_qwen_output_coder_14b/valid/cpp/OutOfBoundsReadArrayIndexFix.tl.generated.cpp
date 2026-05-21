#include "data_compressor.h"

/**
 * Decompress data
 * 
 * Decompresses data using the RLE algorithm.
 * This implementation avoids the out-of-bounds read vulnerability (CWE-125).
 */
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    if (compressed_data == NULL || output_buffer == NULL || compressed_len <= 0 || output_size <= 0) {
        return -1;
    }

    int input_index = 0;
    int output_index = 0;

    /* 
     * Fixed loop condition: Check whether input_index + 1 is less than compressed_len
     * to ensure that we do not perform an out-of-bounds read.
     */
    while (input_index + 1 < compressed_len) {
        unsigned char count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        for (int i = 0; i < (int)count; i++) {
            if (output_index < output_size) {
                output_buffer[output_index++] = value;
            } else {
                /* If the output buffer is full but the input stream hasn't been fully processed, return error as required */
                if (input_index < compressed_len) {
                    return -1;
                }
                break;
            }
        }
    }

    // Handle the case where there's one more byte left to process
    if (input_index < compressed_len) {
        if (output_index < output_size) {
            output_buffer[output_index++] = compressed_data[input_index];
        } else {
            return -1;
        }
    }

    return output_index;
}