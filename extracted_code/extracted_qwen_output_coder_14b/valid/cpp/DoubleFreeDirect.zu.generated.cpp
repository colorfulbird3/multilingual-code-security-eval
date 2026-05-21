```c
int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx) {
    if (data_size < 8) {
        return -1;
    }

    if (compressed_data[0] != 0x43 || compressed_data[1] != 0x4D) {
        return -1;
    }

    unsigned char compression_type = compressed_data[2];
    size_t expected_size = (compressed_data[3] << 24) | (compressed_data[4] << 16) | (compressed_data[5] << 8) | compressed_data[6];

    unsigned char *temp_buffer = (unsigned char *)malloc(expected_size);
    if (!temp_buffer) {
        return -1;
    }
    ctx->temp_buffer = temp_buffer;
    ctx->buffer_size = expected_size;

    size_t payload_size = data_size - 7 - 4; // 7 bytes header + 4 bytes checksum
    const unsigned char *payload = compressed_data + 7;

    if (compression_type == 0) {
        if (payload_size != expected_size) {
            free(temp_buffer);
            return -1;
        }
        memcpy(temp_buffer, payload, expected_size);
    } else if (compression_type == 1) {
        size_t output_index = 0;
        for (size_t i = 0; i < payload_size && output_index < expected_size; i += 2) {
            unsigned char count = payload[i];
            unsigned char value = payload[i + 1];
            for (unsigned char j = 0; j < count && output_index < expected_size; j++) {
                temp_buffer[output_index++] = value;
            }
        }
        if (output_index != expected_size) {
            free(temp_buffer);
            return -1;
        }
    } else {
        free(temp_buffer);
        return -1;
    }

    unsigned int checksum = 0;
    for (size_t i = 0; i < expected_size; i++) {
        checksum += temp_buffer[i];
    }

    unsigned int stored_checksum = (compressed_data[data_size - 4] << 24) | (compressed_data[data_size - 3] << 16) | (compressed_data[data_size - 2] << 8) | compressed_data[data_size - 1];
    if (checksum != stored_checksum) {
        free(temp_buffer);
        return -1;
    }

    return 0;
}
```