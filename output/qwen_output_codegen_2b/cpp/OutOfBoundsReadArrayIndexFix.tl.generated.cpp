len, unsigned char *output_buffer, int output_size)
// {
//   int i, count;
//   unsigned char value;
//
//   /* Set read pointer input_index = 0, write pointer output_index = 0. */
//   i = 0;
//   count = 0;
//
//   /* Set output pointer output_index = 0. */
//   if (output_size > 0)
//     output_buffer[0] = 0;
//
//   /* Loop while input_index + 2 <= compressed_len. */
//   while (i + 2 <= compressed_len)
//     {
//       /* Read count = compressed_data[input_index], value = compressed_data[input_index+1]. */
//       count = compressed_data[i];
//       value = compressed_data[i+1];
//
//       /* Increment input_index. */
//       i += 2;
//
//       /* Write count times into output_buffer. */
//       if (output_size > 0)
//         {
//           output_buffer[count] = value;
//           for (j = 1; j < count; j++) {
//             output_buffer[count+j] = value;
//           }
//         }
//
//       /* Set output pointers to point to the next unit's beginning. */
//       /* Increment output_index. */
//       if (count < output_size)
//         output_buffer[count] = value;
//       else
//         output_buffer[count] = 0;
//       output_index = count;
//     }
//
//   return (output_index);
// }
//
// #endif /* DATA_COMPRESSOR_H */
//
//
// void *compressed_data = NULL;
// int compressed_len = 0;
//
// void *decompressed_data = NULL;
// int decompressed_len = 0;
//
//
// int main()
// {
//   compressed_data = (unsigned char *) malloc(256);
//   decompressed_data = (unsigned char *) malloc(256);
//   //compressed_data = (unsigned char *) malloc(100);
//   //decompressed_data = (unsigned char *) malloc(100);
//   //compressed_len = 100;
//   //decompressed_len = 100;
//   //memcpy(compressed_data, "1234567890", 10);
//   //memcpy(decompressed_data, "1234567890", 10);
//   compressed_data = "ABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABCDEFGHIJABC