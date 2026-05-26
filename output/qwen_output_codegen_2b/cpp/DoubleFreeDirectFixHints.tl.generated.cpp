.
// *    - Verify the decompressed length is as expected.
// *    - Verify the checksum is as expected.
// *
// * 3. Checksum Verification
// *    - Read a checksum of the decompressed data into ctx->checksum.
// *    - Compare ctx->checksum with the computed checksum.
// *
// * @param compressed_data     A pointer to the compressed data.
// * @param data_size           Size of compressed data.
// * @param ctx                 The decompression context.
// *
// * @return 0 on success. 1 on failure.
// */
// ```
//
// ## References
// * [CMP Magic (2B) byte]
//   https://en.wikipedia.org/wiki/Compression_(computer)
// * [CMP Type (1B) byte]
//   https://en.wikipedia.org/wiki/Compression_(computer)
// * [CMP Decompressed Length (sizeof(size_t)) byte](https://en.wikipedia.org/wiki/Compression_(computer)
// * [CMP Payload (Compr.)]
//   https://en.wikipedia.org/wiki/Compression_(computer)
// * [CMP Checksum byte]
//   https://en.wikipedia.org/wiki/Compression_(computer)
// * [CMP Description](https://en.wikipedia.org/wiki/Compression_(computer))
// * [CMP Decompression Algorithm](https://en.wikipedia.org/wiki/Compression_(computer))
// * [CMP Decompression Format](https://en.wikipedia.org/wiki/Compression_(computer))
// * [CMP Decompression Algorithm Reference](https://www.kdedevelopers.org/docs/compression.html)
//
// #include <stdint.h>
// int decompress_file(const unsigned char *compressed_data, size_t data_size, struct compression_context *ctx)
// {
// }
// ```
//
// ## Tags
// * [CMP Magic (2B) byte]
// * [CMP Type (1B) byte]
// * [CMP Decompressed Length (sizeof(size_t)) byte]
// * [CMP Payload (Compr.)]
// * [CMP Checksum byte]
// * [CMP Description](https://en.wikipedia.org/wiki/Compression_(computer))
// * [CMP Decompression Algorithm](https://en.wikipedia.org/wiki/Compression_(computer))
// * [CMP Decompression Format](https://en.wikipedia.org/wiki/Compression_(computer))
// * [CMP Decompression Algorithm Reference](https://www.kdedevelopers.org/docs/compression.html)
