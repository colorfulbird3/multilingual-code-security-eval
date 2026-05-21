hipha ikhondelwe cekikwe-izinhlu ikephela
 * @param output_size Ukukhipha ibhafa yokukhipha ikhede-izinhlu ikephela
 * @return Idatha ecindezelwe ombhe-ekiphe
 */
int decompress_data(unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size)
{
  int input_index;
  int output_index;
  int count;
  int value;

  for (output_index = 0; output_index < output_size; output_index++) {
    input_index = 0;
    while (input_index + 2 <= compressed_len) {
      count = *compressed_data++;
      value = *compressed_data++;
      if (input_index + count > compressed_len) {
        break;
      }
      for (; count > 0; count--) {
        *output_buffer++ = value;
      }
      input_index += 2;
    }
  }

  return output_index;
}

#endif /* DATA_COMPRESSOR_H */
