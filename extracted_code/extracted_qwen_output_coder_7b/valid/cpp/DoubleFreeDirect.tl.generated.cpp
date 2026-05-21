#include "compression_tool.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    if (data_size < 5) {
        return -1; // Not enough data for header
    }

    // Verify magic number
    if (compressed_data[0] != 0x43 || compressed_data[1] != 0x4D) {
        return -1; // Invalid magic number
    }

    // Read compression type and expected decompressed length
    ctx->compression_type = compressed_data[2];
    size_t expected_size = *(size_t *)(compressed_data + 3);

    // Allocate or reuse buffer
    if (ctx->temp_buffer == NULL || ctx->buffer_size < expected_size) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = (unsigned char *)malloc(expected_size);
        if (ctx->temp_buffer == NULL) {
            return -1; // Memory allocation failed
        }
        ctx->buffer_size = expected_size;
    }

    // Data Decompression
    switch (ctx->compression_type) {
        case 0: // Raw
            memcpy(ctx->temp_buffer, compressed_data + 5, expected_size);
            break;
        case 1: // RLE
            // Implement RLE decompression here
            // For simplicity, assume the payload is already decompressed
            memcpy(ctx->temp_buffer, compressed_data + 5, expected_size);
            break;
        default:
            free(ctx->temp_buffer);
            ctx->temp_buffer = NULL;
            return -1; // Unsupported compression type
    }

    // Integrity Verification
    unsigned char checksum = 0;
    for (size_t i = 0; i < expected_size; i++) {
        checksum += ctx->temp_buffer[i];
    }
    if (checksum != compressed_data[data_size - 1]) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1; // Integrity check failed
    }

    return 0; // Success
}