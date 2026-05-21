 /* Raw copy */
            if (payload_len <= ctx->buffer_size) {
                memcpy(ctx->temp_buffer, payload, payload_len);
                decompression_success = 1;
            }
            break;

        case 1: /* RLE decompression */
            {
                size_t output_pos = 0;
                const unsigned char *rle_ptr = payload;
                const unsigned char *rle_end = payload + payload_len;

                while (rle_ptr + 2 <= rle_end && output_pos < ctx->buffer_size) {
                    unsigned char count = *rle_ptr++;
                    unsigned char value = *rle_ptr++;
                    size_t remaining = ctx->buffer_size - output_pos;
                    size_t to_write = (count < remaining)? count : remaining;
                    memset(ctx->temp_buffer + output_pos, value, to_write);
                    output_pos += to_write;
                }

                if (output_pos == ctx->buffer_size) {
                    decompression_success = 1;
                }
            }
            break;

        default:
            /* Unsupported compression type */
            break;
    }

    if (!decompression_success) {
        safe_free_temp_buffer(ctx);
        return -1;
    }

    /* Stage 3: Integrity Verification */
    unsigned char expected_checksum = compressed_data[data_size - 1];
    unsigned char computed_checksum = 0;
    for (size_t i = 0; i < ctx->buffer_size; i++) {
        computed_checksum += ctx->temp_buffer[i];
    }
    computed_checksum &= 0xFF;

    if (computed_checksum!= expected_checksum) {
        safe_free_temp_buffer(ctx);
        return -1;
    }

    return 0;
}
]]>
        </content>
    </code>
</result>
```

    The command to run this example is:

   .. code-block:: shell

        $ cd example_code
        $ python3 compression_tool.py
        $./compression_tool.py src/compression_tool.c > src/compression_tool.c.out

    This produces the following file:

   .. code-block:: c

        #include "compression_tool.h"
        #include <stdlib.h>
        #include <string.h>
        int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
            if (compressed_data == NULL || ctx == NULL) {
                return -1;
            }

            /* Stage 1: Header Parsing */
            const size_t header_len = 2 + 1 + sizeof(size_t); /* magic + type + decompressed len */
            if (data_size < header_len + 1) { /* +1 for checksum */
                return -1;
            }

            /* Verify magic number (0x43 0x4D) */
            if (compressed_data[0]!= 0x43 || compressed_data[1]!= 0x4D) {
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
