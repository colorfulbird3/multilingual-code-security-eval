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