#include <stdlib.h>
#include <string.h>
#include "compression_tool.h"

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    size_t header_len = 2 + 1 + sizeof(size_t);
    size_t trailer_len = 1;

    if (data_size < header_len + trailer_len) {
        return -1;
    }

    if (compressed_data[0] != 0x43 || compressed_data[1] != 0x4D) {
        return -1;
    }

    ctx->compression_type = (int)compressed_data[2];
    size_t expected_size = 0;
    memcpy(&expected_size, &compressed_data[3], sizeof(size_t));

    unsigned char *decompressed_buffer = (unsigned char *)malloc(expected_size);
    if (!decompressed_buffer) {
        return -1;
    }

    size_t compressed_data_start = header_len;
    size_t compressed_data_size = data_size - header_len - trailer_len;

    int result = decompress_algorithm(compressed_data + compressed_data_start, compressed_data_size, decompressed_buffer, &expected_size, ctx->compression_type);
    if (result != 0) {
        free(decompressed_buffer);
        decompressed_buffer = NULL;
        return result;
    }

    ctx->decompressed_data = decompressed_buffer;
    ctx->decompressed_size = expected_size;
    return 0;
}