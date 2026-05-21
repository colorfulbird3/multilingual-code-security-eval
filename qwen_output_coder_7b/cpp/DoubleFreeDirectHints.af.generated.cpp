Hier is die volledige C-kode voor `src/compression_tool.c`:

```xml
<result>
    <code>
        <path>src/compression_tool.c</path>
        <content><![CDATA[
#include "compression_tool.h"
#include <stdlib.h>
#include <string.h>

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    // Step 1: Header Extraction
    if (data_size < 6) {
        return -1; // Insufficient data for header
    }

    uint16_t magic_number = (compressed_data[0] << 8) | compressed_data[1];
    if (magic_number != 0x434D) {
        return -1; // Invalid magic number
    }

    ctx->compression_type = compressed_data[2];
    size_t expected_size = *(size_t *)(compressed_data + 3);

    if (data_size < 3 + sizeof(size_t) + expected_size + 1) {
        return -1; // Insufficient data for decompression
    }

    // Step 2: Decompression
    if (ctx->temp_buffer == NULL || ctx->buffer_size < expected_size) {
        if (ctx->temp_buffer != NULL) {
            free(ctx->temp_buffer);
        }
        ctx->temp_buffer = (unsigned char *)malloc(expected_size);
        if (ctx->temp_buffer == NULL) {
            return -1; // Memory allocation failed
        }
        ctx->buffer_size = expected_size;
    }

    if (ctx->compression_type == 0) {
        memcpy(ctx->temp_buffer, compressed_data + 3 + sizeof(size_t), expected_size);
    } else if (ctx->compression_type == 1) {
        // Placeholder for RLE decompression
        // Implement RLE decompression logic here
        return -1; // Placeholder return value
    } else {
        return -1; // Unsupported compression type
    }

    // Step 3: Integrity Check
    uint8_t checksum = 0;
    for (size_t i = 0; i < expected_size; i++) {
        checksum += ctx->temp_buffer[i];
    }

    if (checksum != compressed_data[data_size - 1]) {
        if (ctx->temp_buffer != NULL) {
            free(ctx->temp_buffer);
            ctx->temp_buffer = NULL;
        }
        return -1