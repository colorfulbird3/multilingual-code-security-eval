while (input_index < compressed_len) {
       unsigned char count = compressed_data[input_index];
       unsigned char value = compressed_data[input_index + 1]; // Potential out-of-bounds read
       input_index += 2;

       for (int i = 0; i < (int)count; i++) {
           if (output_index < output_size) {
               output_buffer[output_index++] = value;
           } else {
               if (input_index < compressed_len) {
                   return -1;
               }
               break;
           }
       }
   }