```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#define MAX_HEADER_SIZE 256
#define MAX_PIXEL_VALUE 255

typedef struct {
    char *version;
    uint8_t *data;
    size_t width;
    size_t height;
    size_t channels;
} Image;

Image* read_ppm(const char *filename) {
    FILE *file = fopen(filename, "rb");
    if (!file) {
        fprintf(stderr, "Error: Cannot open file %s\n", filename);
        return NULL;
    }

    Image *img = (Image*)malloc(sizeof(Image));
    if (!img) {
        fclose(file);
        return NULL;
    }
    img->version = NULL;
    img->data = NULL;

    char header[MAX_HEADER_SIZE];
    if (!fgets(header, sizeof(header), file)) {
        fprintf(stderr, "Error: Cannot read header\n");
        goto error_cleanup;
    }

    // Check magic number
    if (header[0] != 'P' || (header[1] != '5' && header[1] != '6')) {
        fprintf(stderr, "Error: Unsupported format (only P5/P6)\n");
        goto error_cleanup;
    }

    img->version = strdup(header);
    if (!img->version) {
        goto error_cleanup;
    }

    // Skip comments
    char line[MAX_HEADER_SIZE];
    while (fgets(line, sizeof(line), file)) {
        if (line[0] != '#') break;
    }

    // Parse width and height
    if (sscanf(line, "%zu %zu", &img->width, &img->height) != 2) {
        fprintf(stderr, "Error: Invalid dimensions\n");
        goto error_cleanup;
    }

    // Read max value
    int max_val;
    if (!fgets(line, sizeof(line), file) || sscanf(line, "%d", &max_val) != 1) {
        fprintf(stderr, "Error: Invalid max value\n");
        goto error_cleanup;
    }

    if (max_val != MAX_PIXEL_VALUE) {
        fprintf(stderr, "Error: Only 8-bit PPM supported\n");
        goto error_cleanup;
    }

    img->channels = (header[1] == '6') ? 3 : 1;
    size_t data_size = img->width * img->height * img->channels;

    img->data = (uint8_t*)malloc(data_size);
    if (!img->data) {
        goto error_cleanup;
    }

    if (fread(img->data, 1, data_size, file) != data_size) {
        fprintf(stderr, "Error: Incomplete pixel data\n");
        goto error_cleanup;
    }

    fclose(file);
    return img;

error_cleanup:
    if (img->version) free(img->version);
    free(img->data);
    free(img);
    fclose(file);
    return NULL;
}

int main() {
    Image *img = read_ppm("test.ppm");
    if (img) {
        printf("Image loaded: %zux%zu, %zu channels\n", img->width, img->height, img->channels);
        free(img->version);
        free(img->data);
        free(img);
    }
    return 0;
}
```