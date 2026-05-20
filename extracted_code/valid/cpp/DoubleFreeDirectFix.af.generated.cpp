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

    unsigned char *decompressed_buffer = NULL;
    size_t decompressed_size = 0;

    if (ctx->compression_type == 1) {
        decompressed_buffer = malloc(expected_size);
        if (!decompressed_buffer) {
            return -1;
        }
        decompressed_size = expected_size;
        memcpy(decompressed_buffer, &compressed_data[header_len], data_size - header_len - trailer_len);
    } else {
        return -1;
    }

    ctx->decompressed_data = decompressed_buffer;
    ctx->decompressed_size = decompressed_size;
    return 0;
}