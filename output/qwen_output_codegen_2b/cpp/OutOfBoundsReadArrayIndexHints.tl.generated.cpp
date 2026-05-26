unsigned char *compressed_data, int compressed_len, unsigned char *output_buffer, int output_size);
// ```
// * ========== File Structure ==========
// *
// * ```c
// * struct data_compressor {
// *   // compression algorithm
// *   // header_code
// *   // method_signature
// *   unsigned char *compressed_data;
// *   int compressed_len;
// *   unsigned char *output_buffer;
// *   int output_size;
// * };
// * ```
// */

// #include <stdio.h>
// #include <stdlib.h>
// #include <stdint.h>
// #include <string.h>
// #include <stdarg.h>
// #include <assert.h>
// #include <memory.h>
// #include <limits.h>
// #include <stddef.h>

// #include "data_compressor.h"

// #define DATA_COMPRESSOR_VERSION "1.1"

// #define DATA_COMPRESSOR_API_VERSION "1.0"

// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE 4
// #define DATA_COMPRESSOR_MAGIC_HEADER "DATA"

// #define DATA_COMPRESSOR_MAGIC_HEADER_MAGIC "DATA_COMPRESSOR_MAGIC"
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION "DATA_COMPRESSOR_VERSION"
// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE_IN_BYTES 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION_IN_BYTES 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_CODE_IN_BYTES 4

// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE_IN_BYTES sizeof(DATA_COMPRESSOR_MAGIC_HEADER)
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION_IN_BYTES sizeof(DATA_COMPRESSOR_MAGIC_HEADER_VERSION)
// #define DATA_COMPRESSOR_MAGIC_HEADER_CODE_IN_BYTES sizeof(DATA_COMPRESSOR_MAGIC_HEADER_CODE)

// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE_IN_BYTES 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION_IN_BYTES 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_CODE_IN_BYTES 4
//
// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_CODE 4

// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE_IN_BYTES sizeof(DATA_COMPRESSOR_MAGIC_HEADER)
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION_IN_BYTES sizeof(DATA_COMPRESSOR_MAGIC_HEADER_VERSION)
// #define DATA_COMPRESSOR_MAGIC_HEADER_CODE_IN_BYTES sizeof(DATA_COMPRESSOR_MAGIC_HEADER_CODE)
//
// #define DATA_COMPRESSOR_MAGIC_HEADER_SIZE 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_VERSION 4
// #define DATA_COMPRESSOR_MAGIC_HEADER_CODE 4

// #include "compression.c"
