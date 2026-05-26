->compression_type, maak switch-case-statement:
 *      - For RLE:
 *        - Loop over data_size bytes, lees byte i, en loop over data_size bytes, lees byte j,
 *          - Als i != j, voeg byte i toe aan ctx->temp_buffer en update ctx->buffer_size.
 *          - Als i == j, verhoog loonvrag met 1.
 *      - For andere algoritmes:
 *        - Implementeer hierdie algorythme.
 *
 * 3. Integriteitsverifikasie
 *    - Bereken som van ctx->temp_buffer.
 *    - Vergelijke som met kontrolesom uit de cmp-formaat.
 *    - Als som niet overeenkomt, keer terug met mislukking.
 *
 * ========== Beskrywing van Saampers Lêerformaat en Dekompressie Algoritme ==========
 */

void decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx);
#endif /* COMPRESSION_TOOL_H */
```

## kop_kode
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <assert.h>

#include "compression_tool.h"

// Function to validate the magic number
bool validate_magic(unsigned char *magic) {
    return magic[0] == 0x43 && magic[1] == 0x4D;
}

// Function to parse the compression type and expected size from the header
void parse_header(const unsigned char *header, int *compression_type, size_t *expected_size) {
    memcpy(compression_type, &header[2], sizeof(int));
    memcpy(expected_size, &header[6], sizeof(size_t));
}

// Function to decompress data based on the compression type
void decompress_data(const unsigned char *data, size_t data_size, struct compression_context *ctx) {
    int compression_type;
    size_t expected_size;

    // Parse the header
    parse_header(data, &compression_type, &expected_size);

    // Validate the magic number
    if (!validate_magic(&data[0])) {
        fprintf(stderr, "Invalid magic number\n");
        exit(EXIT_FAILURE);
    }

    // Allocate memory for the temporary buffer
    ctx->temp_buffer = malloc(expected_size);
    if (!ctx->temp_buffer) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    ctx->buffer_size = expected_size;

    // Decompress data based on the compression type
    switch (compression_type) {
        case 0: // Raw/Uncompressed
            break;
        case 1: // Run-Length Encoding (RLE)
            decompress_rle(data, data_size, ctx);
            break;
        default:
            fprintf(stderr, "Unsupported compression type\n");
            free(ctx->temp_buffer);
            exit(EXIT_FAILURE);
    }

    // Verify integrity of the decompressed data
    if (!verify_integrity(ctx->temp_buffer, ctx->buffer_size)) {
        fprintf(stderr, "Integrity verification failed\n");
        free(ctx->temp_buffer);
        exit(EXIT_FAILURE);
    }
}

// Function to decompress RLE data
void decompress_rle(const unsigned char *data, size_t data_size, struct compression_context *ctx) {
    for (size_t i = 0; i < data_size; i += 2) {
        unsigned char value = data[i];
        unsigned int count = data[i + 1];

        for (unsigned int j = 0; j < count; j++) {
            ctx->temp_buffer[ctx->buffer_size++] = value;
        }
    }
}

// Function to verify the integrity of the decompressed data
bool verify_integrity(const unsigned char *data, size_t size) {
    uint32_t checksum = 0;
    for (size_t i = 0; i < size; i++) {
        checksum ^= data[i];
    }
    return checksum == data[size - 1];
}

// Main function to test the decompression tool
int main() {
    const unsigned char compressed_data[] = {0x43, 0x4D, 0x00, 0x01, 0x00, 0x00, 0x00, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
    size_t data_size = sizeof(compressed_data);
    struct compression_context ctx;

    decompress_file(compressed_data, data_size, &ctx);

    // Output the decompressed data
    for (size_t i = 0; i < ctx.buffer_size; i++) {
        printf("%d ", ctx