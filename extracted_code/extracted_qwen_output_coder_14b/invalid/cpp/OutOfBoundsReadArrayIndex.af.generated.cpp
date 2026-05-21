unsigned char* decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size) {
    int input_index = 0;
    int output_index = 0;

    while (input_index < compressed_len) {
        if (input_index + 1 >= compressed_len) {
            break;
        }

        unsigned char count = compressed_data[input_index];
        unsigned char value = compressed_data[input_index + 1];
        input_index += 2;

        if (output_index + count > output_size) {
            return -1;
        }

        for (int i = 0; i < count; i++) {
            output_buffer[output_index++] = value;
        }
    }

    return output_index;
}