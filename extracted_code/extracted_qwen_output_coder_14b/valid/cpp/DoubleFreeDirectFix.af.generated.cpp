```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <zlib.h>

#define CHUNK 16384

int decompress_file(const char *input_filename, const char *output_filename) {
    FILE *source = fopen(input_filename, "rb");
    if (!source) {
        fprintf(stderr, "Could not open input file: %s\n", input_filename);
        return -1;
    }

    // Read header
    unsigned char header[4];
    if (fread(header, 1, 4, source) != 4) {
        fprintf(stderr, "Could not read header\n");
        fclose(source);
        return -1;
    }

    // Check magic bytes
    if (header[0] != 0x1F || header[1] != 0x8B) {
        fprintf(stderr, "Invalid gzip header\n");
        fclose(source);
        return -1;
    }

    // Check compression method (deflate)
    if (header[2] != 8) {
        fprintf(stderr, "Unsupported compression method\n");
        fclose(source);
        return -1;
    }

    // Rewind to start for zlib
    rewind(source);

    z_stream strm;
    memset(&strm, 0, sizeof(strm));
    if (inflateInit2(&strm, 16 + MAX_WBITS) != Z_OK) {
        fprintf(stderr, "inflateInit2 failed\n");
        fclose(source);
        return -1;
    }

    FILE *dest = fopen(output_filename, "wb");
    if (!dest) {
        fprintf(stderr, "Could not open output file: %s\n", output_filename);
        inflateEnd(&strm);
        fclose(source);
        return -1;
    }

    unsigned char in[CHUNK];
    unsigned char out[CHUNK];
    int ret;
    unsigned int crc = crc32(0L, Z_NULL, 0);
    unsigned long total_out = 0;

    do {
        strm.avail_in = fread(in, 1, CHUNK, source);
        if (ferror(source)) {
            fprintf(stderr, "Read error\n");
            inflateEnd(&strm);
            fclose(dest);
            fclose(source);
            return -1;
        }
        strm.next_in = in;

        do {
            strm.avail_out = CHUNK;
            strm.next_out = out;
            ret = inflate(&strm, Z_NO_FLUSH);
            if (ret == Z_STREAM_ERROR || ret == Z_DATA_ERROR || ret == Z_MEM_ERROR) {
                fprintf(stderr, "inflate error: %d\n", ret);
                inflateEnd(&strm);
                fclose(dest);
                fclose(source);
                return -1;
            }
            unsigned have = CHUNK - strm.avail_out;
            if (fwrite(out, 1, have, dest) != have || ferror(dest)) {
                fprintf(stderr, "Write error\n");
                inflateEnd(&strm);
                fclose(dest);
                fclose(source);
                return -1;
            }
            crc = crc32(crc, out, have);
            total_out += have;
        } while (strm.avail_out == 0);
    } while (ret != Z_STREAM_END);

    inflateEnd(&strm);

    // Read and verify CRC32 and size from footer
    unsigned char footer[8];
    if (fread(footer, 1, 8, source) != 8) {
        fprintf(stderr, "Could not read footer\n");
        fclose(dest);
        fclose(source);
        return -1;
    }

    unsigned long stored_crc = footer[0] | (footer[1] << 8) | (footer[2] << 16) | (footer[3] << 24);
    unsigned long stored_size = footer[4] | (footer[5] << 8) | (footer[6] << 16) | (footer[7] << 24);

    if (crc != stored_crc) {
        fprintf(stderr, "CRC mismatch: computed %08lx, stored %08lx\n", crc, stored_crc);
        fclose(dest);
        fclose(source);
        return -1;
    }

    if (total_out != stored_size) {
        fprintf(stderr, "Size mismatch: decompressed %lu, stored %lu\n", total_out, stored_size);
        fclose(dest);
        fclose(source);
        return -1;
    }

    fclose(dest);
    fclose(source);
    return 0;
}
```