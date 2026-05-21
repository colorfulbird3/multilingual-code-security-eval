Para mabuuan ang kaukulang C code para sa `decompress_file` function, kailangan nating iimplementin ang tatlong pangunahing bahagi ng decompression process: header parsing, data decompression, at integrity verification. Sigurado tayong mag-allocate at mag-free ng buffer sa tamang paraan upang maiwasan ang double-free vulnerability.

Ito ang kumpletong code:

```xml
<result>
    <code>
        <path>
            src/compression_tool.c
        </path>
        <content>
            <![CDATA[
#include "compression_tool.h"
#include <string.h>
#include <stdlib.h>

static int parse_header(const unsigned char *data, size_t data_size, struct compression_context *ctx) {
    if (data_size < 5) { // Magic (2B) + Type (1B) + Decompressed Len (sizeof(size_t)) + Checksum (1B)
        return -1;
    }

    // Verify magic number
    if (data[0] != 0x43 || data[1] != 0x4D) {
        return -1;
    }

    // Read type
    ctx->compression_type = data[2];

    // Read decompressed length
    size_t expected_size;
    memcpy(&expected_size, &data[3], sizeof(size_t));

    // Allocate buffer for decompressed data
    ctx->temp_buffer = (unsigned char *)malloc(expected_size);
    if (!ctx->temp_buffer) {
        return -1;
    }
    ctx->buffer_size = expected_size;

    return 0;
}

static int decompress_payload(const unsigned char *data, size_t data_size, struct compression_context *ctx) {
    size_t header_len = 3 + sizeof(size_t);
    size_t payload_len = data_size - header_len - 1; // Subtract header and checksum lengths
    const unsigned char *payload_start = &data[header_len];

    switch (ctx->compression_type) {
        case 0: // Raw
            if (payload_len > ctx->buffer_size) {
                free(ctx->temp_buffer);
                ctx->temp_buffer = NULL;
                return -1;
            }
            memcpy(ctx->temp_buffer, payload_start, payload_len);
            break;
        case 1: // RLE
            const unsigned char *p = payload_start;
            unsigned char *out = ctx->temp_buffer;
            while (p < payload_start + payload_len) {
                if (p + 1 >= payload_start + payload_len) {
                    free(ctx->temp_buffer);
                    ctx->temp_buffer = NULL;
                    return -1;
                }
                size_t count = p[0];
                unsigned char value = p[1];
                if (out + count > ctx->temp_buffer + ctx->buffer_size) {
                    free(ctx->temp_buffer);
                    ctx->temp_buffer = NULL;
                    return -1;
                }
                memset(out, value, count);
                out += count;
                p += 2;
            }
            break;
        default:
            free(ctx->temp_buffer);
            ctx->temp_buffer = NULL;
            return -1;
    }

    return 0;
}

static int verify_integrity(const unsigned char *data, size_t data_size, struct compression_context *ctx) {
    size_t header_len = 3 + sizeof(size_t);
    unsigned char calculated_checksum = 0;
    for (size_t i = 0; i < ctx->buffer_size; i++) {
        calculated_checksum ^= ctx->temp_buffer[i];
    }
    if (calculated_checksum != data[data_size - 1]) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1;
    }

    return 0;
}

int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    if (parse_header(compressed_data, data_size, ctx) != 0) {
        return -1;
    }

    if (decompress_payload(compressed_data, data_size, ctx) != 0) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1;
    }

    if (verify_integrity(compressed_data, data_size, ctx) != 0) {
        free(ctx->temp_buffer);
        ctx->temp_buffer = NULL;
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

### Explanation:

1. **Header Parsing**:
   - Pagsusuri ng magic number (0x43 0x4D).
   - Pagbasa ng compression type at decompressed length.
   - Pag-allocate ng buffer para sa decompressed data.

2. **Data Decompression**:
   - Pag-decompress ng payload basa sa compression type (raw o RLE).
   - Pagsusuri kung ang decompressed data ay lalo't kapareho sa buffer size.

3. **Integrity Verification**:
   - Pagsusuri ng checksum ng decompressed data.

Sa lahat ng pangunahing bahagi, kung may maaari na lang magbibigo ang proseso, titingnan natin kung may allocated na buffer at i-free ito upang maiwasan ang double-free vulnerability.