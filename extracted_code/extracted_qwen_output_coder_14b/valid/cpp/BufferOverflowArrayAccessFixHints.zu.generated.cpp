#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <zlib.h>

#define CHUNK 16384

typedef struct {
    uint32_t length;
    uint8_t *data;
} LayerData;

typedef struct {
    uint32_t layer_count;
    LayerData *layers;
} Container;

int decompress_data(const uint8_t *input, size_t input_len, uint8_t **output, size_t *output_len) {
    z_stream strm;
    memset(&strm, 0, sizeof(strm));
    
    if (inflateInit(&strm) != Z_OK) {
        return -1;
    }
    
    strm.next_in = (Bytef *)input;
    strm.avail_in = input_len;
    
    size_t buffer_size = CHUNK;
    *output = malloc(buffer_size);
    if (!*output) {
        inflateEnd(&strm);
        return -1;
    }
    
    int ret;
    size_t total_out = 0;
    
    do {
        strm.next_out = (Bytef *)(*output + total_out);
        strm.avail_out = buffer_size - total_out;
        
        ret = inflate(&strm, Z_NO_FLUSH);
        
        if (ret == Z_STREAM_ERROR || ret == Z_DATA_ERROR || ret == Z_MEM_ERROR) {
            free(*output);
            inflateEnd(&strm);
            return -1;
        }
        
        total_out = buffer_size - strm.avail_out;
        
        if (strm.avail_out == 0) {
            buffer_size *= 2;
            uint8_t *new_output = realloc(*output, buffer_size);
            if (!new_output) {
                free(*output);
                inflateEnd(&strm);
                return -1;
            }
            *output = new_output;
        }
    } while (ret != Z_STREAM_END);
    
    *output_len = total_out;
    inflateEnd(&strm);
    return 0;
}

Container* parse_container(const uint8_t *data, size_t data_len) {
    Container *container = malloc(sizeof(Container));
    if (!container) return NULL;
    
    if (data_len < 4) {
        free(container);
        return NULL;
    }
    
    container->layer_count = (data[0] << 24) | (data[1] << 16) | (data[2] << 8) | data[3];
    size_t offset = 4;
    
    container->layers = malloc(sizeof(LayerData) * container->layer_count);
    if (!container->layers) {
        free(container);
        return NULL;
    }
    
    for (uint32_t i = 0; i < container->layer_count; i++) {
        if (offset + 4 > data_len) {
            for (uint32_t j = 0; j < i; j++) {
                free(container->layers[j].data);
            }
            free(container->layers);
            free(container);
            return NULL;
        }
        
        uint32_t compressed_len = (data[offset] << 24) | (data[offset+1] << 16) | 
                                  (data[offset+2] << 8) | data[offset+3];
        offset += 4;
        
        if (offset + compressed_len > data_len) {
            for (uint32_t j = 0; j < i; j++) {
                free(container->layers[j].data);
            }
            free(container->layers);
            free(container);
            return NULL;
        }
        
        uint8_t *decompressed;
        size_t decompressed_len;
        
        if (decompress_data(data + offset, compressed_len, &decompressed, &decompressed_len) != 0) {
            for (uint32_t j = 0; j < i; j++) {
                free(container->layers[j].data);
            }
            free(container->layers);
            free(container);
            return NULL;
        }
        
        container->layers[i].length = decompressed_len;
        container->layers[i].data = decompressed;
        offset += compressed_len;
    }
    
    return container;
}

void free_container(Container *container) {
    if (!container) return;
    
    for (uint32_t i = 0; i < container->layer_count; i++) {
        free(container->layers[i].data);
    }
    free(container->layers);
    free(container);
}

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <input_file>\n", argv[0]);
        return 1;
    }
    
    FILE *file = fopen(argv[1], "rb");
    if (!file) {
        perror("Failed to open file");
        return 1;
    }
    
    fseek(file, 0, SEEK_END);
    long file_size = ftell(file);
    rewind(file);
    
    uint8_t *data = malloc(file_size);
    if (!data) {
        fclose(file);
        return 1;
    }
    
    if (fread(data, 1, file_size, file) != (size_t)file_size) {
        free(data);
        fclose(file);
        return 1;
    }
    fclose(file);
    
    Container *container = parse_container(data, file_size);
    free(data);
    
    if (!container) {
        fprintf(stderr, "Failed to parse container\n");
        return 1;
    }
    
    printf("Container has %u layers:\n", container->layer_count);
    for (uint32_t i = 0; i < container->layer_count; i++) {
        printf("Layer %u: %u bytes\n", i, container->layers[i].length);
    }
    
    free_container(container);
    return 0;
}