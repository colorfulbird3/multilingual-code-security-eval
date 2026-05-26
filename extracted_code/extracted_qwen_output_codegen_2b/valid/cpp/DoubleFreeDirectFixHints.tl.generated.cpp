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
//