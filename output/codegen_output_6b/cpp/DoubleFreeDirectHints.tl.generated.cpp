 data to be decompressed.
 * @param data_size Size of the compressed data.
 * @param ctx Memory region used by the function to store the context used during decompression.
 * @returns 0 on success, -1 on failure.
 */
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx)
{
    // header parsing
    if (data_size < 2) {
        return -1;
    }
    // magic & type
    if (compressed_data[0]!= 0x43 || compressed_data[1]!= 0x4D) {
        return -1;
    }
    // length
    size_t expected_size = (data_size - 2);
    if (expected_size > ctx->buffer_size) {
        ctx->temp_buffer = malloc(expected_size);
        if (!ctx->temp_buffer) {
            return -1;
        }
    } else {
        ctx->temp_buffer = ctx->buffer_size;
    }
    // payload
    size_t payload_size = expected_size - sizeof(size_t);
    memcpy(ctx->temp_buffer, &expected_size, sizeof(size_t));
    memcpy(ctx->temp_buffer + sizeof(size_t), compressed_data + 2, payload_size);
    // checksum
    if (expected_size < data_size) {
        if (expected_size!= checksum((uint8_t *)compressed_data + 2 + payload_size, expected_size - 2) + 2) {
            return -1;
        }
    }
    // success
    return 0;
}

#endif
#endif
