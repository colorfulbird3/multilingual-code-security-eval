 failure.
 */
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx)
{
    // Allocate or reuse buffer
    if (ctx->temp_buffer) {
        ctx->temp_buffer = NULL;
        ctx->buffer_size = 0;
        ctx->compression_type = 0;
    } else {
        ctx->temp_buffer = malloc(data_size);
        ctx->buffer_size = data_size;
        if (!ctx->temp_buffer) {
            return -1;
        }
    }

    // Parse header
    if (data_size < (sizeof(uint32_t) + sizeof(size_t))) {
        return -1;
    }

    // Validate magic
    if (compressed_data[0]!= 0x43 || compressed_data[1]!= 0x4D) {
        return -1;
    }

    // Read compression type
    ctx->compression_type = compressed_data[2];

    // Read expected_size
    size_t expected_size = *(size_t*)&compressed_data[3];

    // Parse payload
    if (data_size < (expected_size+sizeof(uint32_t))) {
        return -1;
    }

    // Decompress payload
    if (ctx->compression_type == 1) {
        // RLE
        if (expected_size > ctx->buffer_size) {
            return -1;
        }

        decompress_rle(compressed_data + sizeof(uint32_t), expected_size, ctx->temp_buffer, ctx->buffer_size, decompressed_size);
    } else {
        // Raw
        if (expected_size > ctx->buffer_size) {
            return -1;
        }

        memcpy(ctx->temp_buffer, compressed_data+sizeof(uint32_t), expected_size);
    }

    // Validate checksum
    uint32_t checksum = *(uint32_t*)&compressed_data[expected_size];
    uint32_t