```c
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
     * Vulnerability trigger point: The loop condition only checks whether input_index is less than compressed_len.
     * However, inside the loop body, each decompression unit logically requires reading 2 bytes.
     * If compressed_len is odd, reading the 'value' of the last unit will cause
     * compressed_data[input_index
```