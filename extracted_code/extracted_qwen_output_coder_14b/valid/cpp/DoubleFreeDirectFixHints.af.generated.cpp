```c
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    unsigned char *decompressed_buffer = NULL;
    size_t decompressed_size = 0;
    int result = -1;

    // Parse header
    if (data_size < sizeof(struct cmp_header)) {
        goto cleanup;
    }
    struct cmp_header *header = (struct cmp_header *)compressed_data;
    decompressed_size = header->original_size;

    // Allocate buffer
    decompressed_buffer = (unsigned char *)malloc(decompressed_size);
    if (!decompressed_buffer) {
        goto cleanup;
    }

    // Decompress data
    if (decompress_data(compressed_data + sizeof(struct cmp_header),
                        data_size - sizeof(struct cmp_header) - sizeof(uint32_t),
                        decompressed_buffer,
                        &decompressed_size) != 0) {
        goto cleanup;
    }

    // Verify integrity
    uint32_t expected_checksum = *(uint32_t *)(compressed_data + data_size - sizeof(uint32_t));
    uint32_t actual_checksum = calculate_checksum(decompressed_buffer, decompressed_size);
    if (expected_checksum != actual_checksum) {
        goto cleanup;
    }

    // Success
    ctx->decompressed_data = decompressed_buffer;
    ctx->decompressed_size = decompressed_size;
    result = 0;

cleanup:
    if (result != 0 && decompressed_buffer) {
        free(decompressed_buffer);
    }
    return result;
}
```