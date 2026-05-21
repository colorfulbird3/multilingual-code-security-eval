int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    int input_index = 0;
    int output_index = 0;

    while (input_index < compressed_len && output_index < output_size) {
        if (input_index + 2 > compressed_len) {
            break;
        }

        if (output_index >= output_size) {
            if (input_index < compressed_len) {
                return -1;
            }
            break;
        }

        int count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        if (count < 1 || count > 255) {
            return -1;
        }

        for (int i = 0; i < count; i++) {
            if (output_index >= output_size) {
                return -1;
            }
            output_buffer[output_index++] = value;
        }
    }

    return output_index;
}