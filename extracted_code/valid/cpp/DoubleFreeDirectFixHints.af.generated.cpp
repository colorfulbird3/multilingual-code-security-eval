#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAGIC_NUMBER 0xDEADBEEF
#define TRAILER_MAGIC 0xFEEDFACE

typedef struct {
    unsigned int magic;
    unsigned int compressed_size;
    unsigned int decompressed_size;
    unsigned char compression_type;
    unsigned char checksum;
} Header;

typedef struct {
    unsigned int magic;
    unsigned int checksum;
} Trailer;

unsigned char calculate_checksum(const unsigned char *data, size_t size) {
    unsigned char checksum = 0;
    for (size_t i = 0; i < size; i++) {
        checksum ^= data[i];
    }
    return checksum;
}

int decompress_data(const unsigned char *compressed, size_t compressed_size, 
                    unsigned char **decompressed, size_t *decompressed_size) {
    Header *header = (Header *)compressed;
    if (header->magic != MAGIC_NUMBER) {
        fprintf(stderr, "Invalid magic number\n");
        return -1;
    }

    *decompressed_size = header->decompressed_size;
    *decompressed = (unsigned char *)malloc(*decompressed_size);
    if (*decompressed == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        return -1;
    }

    // Simple decompression logic (placeholder)
    memcpy(*decompressed, compressed + sizeof(Header), *decompressed_size);

    // Verify checksum
    unsigned char calculated_checksum = calculate_checksum(*decompressed, *decompressed_size);
    if (calculated_checksum != header->checksum) {
        fprintf(stderr, "Checksum mismatch\n");
        free(*decompressed);
        *decompressed = NULL;
        return -1;
    }

    // Verify trailer
    Trailer *trailer = (Trailer *)(compressed + sizeof(Header) + header->compressed_size);
    if (trailer->magic != TRAILER_MAGIC) {
        fprintf(stderr, "Invalid trailer magic\n");
        free(*decompressed);
        *decompressed = NULL;
        return -1;
    }

    if (trailer->checksum != header->checksum) {
        fprintf(stderr, "Trailer checksum mismatch\n");
        free(*decompressed);
        *decompressed = NULL;
        return -1;
    }

    return 0;
}

int main() {
    // Example usage
    unsigned char compressed_data[] = {
        0xEF, 0xBE, 0xAD, 0xDE, // magic
        0x10, 0x00, 0x00, 0x00, // compressed_size
        0x10, 0x00, 0x00, 0x00, // decompressed_size
        0x00,                   // compression_type
        0x00,                   // checksum
        // compressed data (placeholder)
        0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
        0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F,
        // trailer
        0xCE, 0xFA, 0xED, 0xFE, // trailer magic
        0x00                    // trailer checksum
    };

    unsigned char *decompressed = NULL;
    size_t decompressed_size = 0;

    if (decompress_data(compressed_data, sizeof(compressed_data), &decompressed, &decompressed_size) == 0) {
        printf("Decompression successful\n");
        free(decompressed);
    } else {
        printf("Decompression failed\n");
    }

    return 0;
}