;
// }
// unsigned char count = payload[i];
// unsigned char value = payload[i + 1];
// for (unsigned char j = 0; j < count && output_pos < ctx->buffer_size; j++) {
// ctx->temp_buffer[output_pos++] = value;
// }
// }
// } else {
// free(ctx->temp_buffer);
// ctx->temp_buffer = NULL;
// return -1;
// }
// // Integrity verification
// unsigned char checksum = 0;
// for (size_t i = 0; i < ctx->buffer_size; i++) {
// checksum += ctx->temp_buffer[i];
// }
// if (checksum!= compressed_data[data_size - 1]) {
// free(ctx->temp_buffer);
// ctx->temp_buffer = NULL;
// return -1;
// }
// return 0;
// }
// ]]>
// </content>
// </code>
// </result>
// ```
//
// @param ctx
// @param compressed_data
// @param data_size
// @return
// 0 on success, -1 otherwise
int decompress_file(struct compression_context *ctx, const unsigned char *compressed_data, size_t data_size) {
  // Check if the code is correct
  if (compressed_data == NULL || data_size <= 1) return -1;

  // Code parsing
  if (data_size < 3 + sizeof(size_t)) {
    return -1;
  }

  ctx->compression_type = compressed_data[2];
  size_t expected_size;
  memcpy(&expected_size, compressed_data + 3, sizeof(size_t));
  if (expected_size > data_size) {
    return -1;
  }

  // Allocate temporary buffer
  ctx->temp_buffer = (unsigned char *)malloc(expected_size);
  if (!ctx->temp_buffer) {
    return -1;
  }
  ctx->buffer_size = expected_size;

  size_t header_len = 3 + sizeof(size_t);
  size_t payload_len = data_size - header_len - 1;
  const unsigned char *payload = compressed_data + header_len;
  // Data decompression
  if (ctx->compression_type == 0) {
    if (payload_len > ctx->buffer_size) {
      free(ctx->temp_buffer);
      ctx->temp_buffer = NULL;
      return -1;
    }
    memcpy(ctx->temp_buffer, payload, payload_len);
  } else if (ctx->compression_type == 1) {
    // RLE decompression
    size_t output_pos = 0;
    for (size_t i = 0; i < payload_len && output_pos < ctx->buffer_size; i += 2) {
      if (i + 1 >= payload_len) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1;
      }
      unsigned char count = payload[i];
      unsigned char value = payload[i + 1];
      for (unsigned char j = 0; j < count && output_pos < ctx->buffer_size; j++) {
        ctx->temp_buffer[output_pos++] = value;
      }
    }
  } else {
    free(ctx->temp_buffer);
    ctx->temp_buffer = NULL;
    return -1;
  }
  // Integrity verification
  unsigned char checksum = 0;
  for (size_t i = 0; i < ctx->buffer_size; i++) {
    checksum += ctx->temp_buffer[i];
  }
  if (checksum!= payload[data_size - 1]) {
    free(ctx->temp_buffer);
    ctx->temp_buffer = NULL;
    return -1;
  }
  return 0;
}
