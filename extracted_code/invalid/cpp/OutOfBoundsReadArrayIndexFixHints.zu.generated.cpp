while (input_index < compressed_len) {
       unsigned char count = compressed_data[input_index];
       unsigned char value = compressed_data[input_index + 1];
       input_index += 2;