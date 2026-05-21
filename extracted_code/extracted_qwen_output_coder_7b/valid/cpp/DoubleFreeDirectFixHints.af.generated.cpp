#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAGIC_NUMBER 0xDEADBEEF
#define TRAILER_MAGIC 0xCAFEBABE

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
                    unsigned char **decompressed, size_t *decompressed_size,
                    unsigned char compression_type) {
    if (compressed == NULL || decompressed == NULL || decompressed_size == NULL) {
        return -1;
    }

    *decompressed = NULL;
    *decompressed_size = 0;

    if (compression_type == 0) {
        // No compression, just copy
        *decompressed = (unsigned char *)malloc(compressed_size);
        if (*decompressed == NULL) {
            return -1;
        }
        memcpy(*decompressed, compressed, compressed_size);
        *decompressed_size = compressed_size;
        return 0;
    } else if (compression_type == 1) {
        // Simple RLE decompression
        size_t output_size = 0;
        size_t input_pos = 0;
        
        // First pass: calculate output size
        while (input_pos < compressed_size) {
            if (input_pos + 2 > compressed_size) {
                return -1;
            }
            unsigned char count = compressed[input_pos];
            input_pos++;
            output_size += count;
            input_pos++; // skip the byte value
        }

        *decompressed = (unsigned char *)malloc(output_size);
        if (*decompressed == NULL) {
            return -1;
        }

        // Second pass: decompress
        size_t output_pos = 0;
        input_pos = 0;
        while (input_pos < compressed_size) {
            unsigned char count = compressed[input_pos];
            input_pos++;
            unsigned char value = compressed[input_pos];
            input_pos++;
            for (unsigned char i = 0; i < count; i++) {
                (*decompressed)[output_pos++] = value;
            }
        }

        *decompressed_size = output_size;
        return 0;
    }

    return -1;
}

int decompress_file(const char *filename) {
    FILE *file = fopen(filename, "rb");
    if (file == NULL) {
        return -1;
    }

    // Read header
    Header header;
    if (fread(&header, sizeof(Header), 1, file) != 1) {
        fclose(file);
        return -1;
    }

    if (header.magic != MAGIC_NUMBER) {
        fclose(file);
        return -1;
    }

    // Read compressed data
    unsigned char *compressed = (unsigned char *)malloc(header.compressed_size);
    if (compressed == NULL) {
        fclose(file);
        return -1;
    }

    if (fread(compressed, 1, header.compressed_size, file) != header.compressed_size) {
        free(compressed);
        fclose(file);
        return -1;
    }

    // Read trailer
    Trailer trailer;
    if (fread(&trailer, sizeof(Trailer), 1, file) != 1) {
        free(compressed);
        fclose(file);
        return -1;
    }

    if (trailer.magic != TRAILER_MAGIC) {
        free(compressed);
        fclose(file);
        return -1;
    }

    fclose(file);

    // Decompress
    unsigned char *decompressed = NULL;
    size_t decompressed_size = 0;
    int result = decompress_data(compressed, header.compressed_size, 
                                 &decompressed, &decompressed_size,
                                 header.compression_type);

    free(compressed);

    if (result != 0) {
        return -1;
    }

    // Verify checksum
    unsigned char calculated_checksum = calculate_checksum(decompressed, decompressed_size);
    if (calculated_checksum != header.checksum || calculated_checksum != trailer.checksum) {
        free(decompressed);
        return -1;
    }

    // Process decompressed data (example: write to stdout)
    fwrite(decompressed, 1, decompressed_size, stdout);

    free(decompressed);
    return 0;
}