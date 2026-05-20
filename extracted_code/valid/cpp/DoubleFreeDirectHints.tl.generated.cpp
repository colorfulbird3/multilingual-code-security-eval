#include "compression_tool.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    // Header lengths
    const size_t HEADER_LEN = 2 + 1 + sizeof(size_t);
    if (data_size < HEADER_LEN) {
        return -1;
    }

    // Extract header information
    uint16_t magic = ((uint16_t)compressed_data[0] << 8) | compressed_data[1];
    uint8_t type = compressed_data[2];
    size_t expected_size = *(size_t *)(compressed_data + 3);

    // Check magic number
    if (magic != 0x434D) {
        return -1;
    }

    // Allocate buffer if necessary
    if (ctx->temp_buffer == NULL || ctx->buffer_size < expected_size) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = (unsigned char *)malloc(expected_size);
        if (ctx->temp_buffer == NULL) {
            return -1;
        }
        ctx->buffer_size = expected_size;
    }

    // Decompression based on type
    switch (type) {
        case 0: // Raw data
            memcpy(ctx->temp_buffer, compressed_data + HEADER_LEN, expected_size);
            break;
        case 1: // RLE
            // Implement RLE decompression here
            // For simplicity, assume the payload is already decompressed
            memcpy(ctx->temp_buffer, compressed_data + HEADER_LEN, expected_size);
            break;
        default:
            free(ctx->temp_buffer);
            ctx->temp_buffer = NULL;
            return -1;
    }

    // Integrity verification
    uint8_t checksum = 0;
    for (size_t i = 0; i < expected_size; i++) {
        checksum += ctx->temp_buffer[i];
    }
    if (checksum != compressed_data[data_size - 1]) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1;
    }

    return 0;
}