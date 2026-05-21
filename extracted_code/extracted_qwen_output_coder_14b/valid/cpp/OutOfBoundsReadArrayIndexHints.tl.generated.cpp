#include "data_compressor.h"

int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    int input_index = 0;
    int output_index = 0;

    while (input_index + 2 <= compressed_len && output_index < output_size) {
        unsigned char count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];

        if (count == 0) {
            // Reserved value, treat as error
            return -1;
        }

        for (unsigned char i = 0; i < count; i++) {
            if (output_index >= output_size) {
                // Output buffer overflow
                return -1;
            }
            output_buffer[output_index++] = value;
        }

        input_index += 2;
    }

    // If we stopped due to insufficient output_size while input_index < compressed_len, treat as output buffer overflow
    if (input_index < compressed_len) {
        return -1;
    }

    return output_index;
}