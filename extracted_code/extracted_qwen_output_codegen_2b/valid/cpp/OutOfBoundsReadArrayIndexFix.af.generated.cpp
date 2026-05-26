#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#define SIZE_MAX  (1u << 31)

static
void
compress_data(unsigned char *source_data, int source_data_len, unsigned char *output_buffer, int *output_data_len)
{
    if (source_data_len <= SIZE_MAX)
    {
        *output_data_len = source_data_len;
        memcpy(output_buffer, source_data, source_data_len);
    }
    else
    {
        *output_data_len = 0;
        memcpy(output_buffer, source_data, SIZE_MAX);
    }
}

static
void
decompress_data(unsigned char *compressed_data, int compressed_data_len, unsigned char *output_buffer, int output_buffer_len)
{
    if (compressed_data_len > 0 && compressed_data_len <= output_buffer_len)
    {
        memcpy(output_buffer, compressed_data, compressed_data_len);
        *output_data_len = compressed_data_len;
    }
    else
    {
        *output_data_len = 0;
    }
}

int
main(int argc, char **argv)
{
    FILE *fp = fopen(argv[2], "rb");
    if (fp == NULL)
    {
        fprintf(stderr, "Fout: %s\n", argv[2]);
        return 1;
    }

    int compressed_len = fread(&compressed_len, 1, sizeof(compressed_len), fp);
    fseek(fp, 0, SEEK_SET);

    unsigned char *source_data = (unsigned char *)malloc(compressed_len);
    compressed_len = fread(source_data, 1, compressed_len, fp);
    fclose(fp);

    unsigned char *output_buffer = (unsigned char *)malloc(compressed_len);
    compress_data(source_data, compressed_len, output_buffer, &compressed_