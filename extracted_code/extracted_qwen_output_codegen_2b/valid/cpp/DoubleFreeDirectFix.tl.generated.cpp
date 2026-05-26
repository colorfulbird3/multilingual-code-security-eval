
// *    - Validate checksum.
// *
// * [Header Format]
// *   - Magic: Fixed 2 bytes to identify CMP streams (e.g., 0x43 0x4D).
// *   - Type: 1 byte indicating compression algorithm. 0 = raw/uncompressed, 1 = RLE, others reserved.
// *   - Decompressed Len: sizeof(size_t) bytes indicating expected decompressed size, used for allocation or validation.
// *   - Payload: Immediately follows "Decompressed Len", length = (data_size - header_len - trailer_len), decompressed per type.
// *
// * [Decompression Algorithm: Three Stages of decompress_file]
// *
// * 1. Header Parsing
// *    - If data_size < header length (magic + type + decompressed len), return failure.
// *    - Validate magic number; if mismatch, return failure.
// *    - Read type into ctx->compression_type, read expected_size.
// *    - Allocate or reuse buffer: set ctx->temp_buffer to hold expected_size,
// *      ctx->buffer_size = expected_size. If allocation fails, return failure.
// *
// * 2. Data Decompression
// *    - Based on ctx->compression_type: type 0 copies payload directly to ctx->temp_buffer;
// *      type 1 decompresses payload (e.g., RLE) into ctx->temp_buffer, not exceeding ctx->buffer_size.
// *    - If payload length or decompressed result exceeds ctx->buffer_size, or data is invalid, return failure;
// *      if ctx->temp_buffer was allocated in this stage, it must be freed and set to NULL to avoid double-free later.
// *
// * 3. Integrity Verification
// *    - Validate checksum.
// *
// * [Header Format]
// *   - Magic: Fixed 2 bytes to identify CMP streams (e.g., 0x43 0x4D).
// *   - Type: 1 byte indicating compression algorithm. 0 = raw/uncompressed, 1 = RLE, others reserved.
// *   - Decompressed Len: sizeof(size_t) bytes indicating expected decompressed size, used for allocation or validation.
// *   - Payload: Immediately follows "Decompressed Len", length = (data_size - header_len - trailer_len), decompressed per type.
// *
// * [Decompression Algorithm: Three Stages of decompress_file]
// *
// * 1. Header Parsing
// *    - If data_size < header length (magic + type + decompressed len), return failure.
// *    - Validate magic number; if mismatch, return failure.
// *    - Read type into ctx->compression_type, read expected_size.
// *    - Allocate or reuse buffer: set ctx->temp_buffer to hold expected_size,
// *      ctx->buffer_size = expected_size. If allocation fails, return failure.
// *
// * 2. Data Decompression
// *    - Based on ctx->compression_type: type 0 copies payload directly to ctx->temp_buffer;
// *      type 1 decompresses payload (e.g., RLE) into ctx->temp_buffer, not exceeding ctx->buffer_size.
// *    - If payload length or decompressed result exceeds ctx->buffer_size, or data is invalid, return failure;
// *      if ctx->temp_buffer was allocated in this stage, it must be freed and set to NULL to avoid double-free later.
// *
// * 3. Integrity Verification
// *    - Validate checksum.
*/
// [Header Format]
//    - Magic: Fixed 2 bytes to identify CMP streams (e.g., 0x43 0x4D).
//    - Type: 1 byte indicating compression algorithm. 0 = raw/uncompressed, 1 = RLE, others reserved.
//    - Decompressed Len: sizeof(size_t) bytes indicating expected decompressed size, used for allocation or validation.
//    - Payload: Immediately following "Decompressed Len", length = (data_size - header_len - trailer_len), decompressed per type.
//
// [Decompression Algorithm: Three Stages of decompress_file]
//    - Header Parsing
//        - If data_size <