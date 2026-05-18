 ```xml
<result>
    <code>
        <path>
            src/compression_tool.c
        </path>
        <content>
            <![CDATA[
#include "compression_tool.h"
#include <stdlib.h>
#include <string.h>

/* Helper: free temp buffer and set to NULL */
static void safe_free_temp_buffer(struct compression_context *ctx) {
    if (ctx->temp_buffer != NULL) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        ctx->buffer_size = 0;
    }
}

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    if (compressed_data == NULL || ctx == NULL) {
        return -1;
    }

    /* Stage 1: Header Parsing */
    const size_t header_len = 2 + 1 + sizeof(size_t); /* magic + type + decompressed len */
    if (data_size < header_len + 1) { /* +1 for checksum */
        safe_free_temp_buffer(ctx);
        return -1;
    }

    /* Verify magic number (0x43 0x4D) */
    if (compressed_data[0] != 0x43 || compressed_data[1] != 0x4D) {
        safe_free_temp_buffer(ctx);
        return -1;
    }

    /* Read compression type */
    ctx->compression_type = compressed_data[2];

    /* Read expected decompressed length */
    size_t expected_size;
    memcpy(&expected_size, compressed_data + 3, sizeof(size_t));

    /* Allocate temporary buffer */
    ctx->temp_buffer = (unsigned char *)malloc(expected_size);
    if (ctx->temp_buffer == NULL) {
        ctx->buffer_size = 0;
        return -1;
    }
    ctx->buffer_size = expected_size;

    /* Stage 2: Data Decompression */
    const unsigned char *payload = compressed_data + header_len;
    size_t payload_len = data_size - header_len - 1; /* -1 for checksum */
    int decompression_success = 0;

    switch (ctx->compression_type) {
        case 0: /* Raw copy */
            if (payload_len <= ctx->buffer_size) {
                memcpy(ctx->temp_buffer, payload, payload_len);
                decompression_success = 1;
            }
            break;

        case 1: /* RLE decompression */
            {
                size_t output_pos = 